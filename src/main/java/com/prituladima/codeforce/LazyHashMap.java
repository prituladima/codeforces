package com.prituladima.codeforce;

import java.util.*;

public class LazyHashMap<KeyType, ValueType> implements Map<KeyType, ValueType> {

    /**
     * Functional flags
     */
//    private static final int LAZY_ADD_FLAG = 1 << 1;
//    private static final int LAZY_DELETE_FLAG = 1 << 2;
//    private static final int OPTIMIZE_STRINGS_FLAG = 1 << 3;
//    private static final int RESIZABLE_RING_FLAG = 1 << 4;
//    private static final int SUPPORT_NULL_AS_KEY = 1 << 5;
//    private static final int SUPPORT_NULL_AS_VALUE = 1 << 5;

    private final int flags;

    /**
     * Experimental initial data
     */
    private static final int INITIAL_HASHMAP_SIZE = 2;
    private static final int INITIAL_LIST_SIZE = 2;
//    private static final double LOAD_FACTOR = 1.0;//0.75;

    /**
     * Memory efficient hash table state
     */
    private int hashMapSize;

    private int hashMapCapacity;

    private int[] writePointers;
    private Object[][] keyStorage;
    private Object[][] valueStorage;

    /**
     * Circular buffer
     */
    private int circularBufferSize;

    private int circularBufferCapacity;

    private int readPointer;
    private int writePointer;

    private Object[] circularBufferForKey;
    private Object[] circularBufferForValue;


    public LazyHashMap(int flags) {
        this.flags = flags;
        defaultSetUp();
    }

    private void defaultSetUp() {
        if (INITIAL_HASHMAP_SIZE < 2) {
            throw new BrokenInvariantException("INITIAL_HASHMAP_SIZE < 2");
        }

        //Hashmap params
        this.hashMapSize = 0;
        this.hashMapCapacity = INITIAL_HASHMAP_SIZE;

        this.writePointers = new int[INITIAL_HASHMAP_SIZE];
        //This is already 0's
        //Arrays.fill(this.keyStorageSizes, 0);

        this.keyStorage = new Object[INITIAL_HASHMAP_SIZE][];
        //This is lazy
        //Arrays.fill(this.keyStorage, new Object[INITIAL_LIST_SIZE]);

        this.valueStorage = new Object[INITIAL_HASHMAP_SIZE][];
        //This is lazy
        //Arrays.fill(this.valueStorage, new Object[INITIAL_LIST_SIZE]);


        //Cache circle buffer
        this.circularBufferSize = 0;
        this.circularBufferCapacity = log2(INITIAL_HASHMAP_SIZE);

        this.readPointer = 0;
        this.writePointer = 0;

        this.circularBufferForKey = new Object[circularBufferCapacity];
        //This is already null's
        //Arrays.fill(this.ringBufferForKey, null);
        this.circularBufferForValue = new Object[circularBufferCapacity];
        //This is already null's
        //Arrays.fill(this.ringBufferForValue, null);
    }

    @Override
    public ValueType put(KeyType key, ValueType value) {

        if (key == null) {
            throw new BrokenInvariantException("null keys are not supported");
        }

//        if (circularBufferCapacity <= 0) {
//            throw new BrokenInvariantException("ringSize must be > 0");
//        }

        //Is buffer is already full?
        if (writePointer == readPointer && circularBufferSize == circularBufferCapacity) {
            //remove O(log2 (hashMapCapacity)) from buffer
            flushBuffer();
        }

        circularBufferForKey[writePointer] = key;
        circularBufferForValue[writePointer] = value;

        writePointer++;

        if (writePointer == circularBufferCapacity) {
            writePointer = 0;
        }

        circularBufferSize++;

        return value;
    }

    private void flushBuffer() {
        while (writePointer != readPointer || circularBufferSize == circularBufferCapacity) {

            putInternal(circularBufferForKey[readPointer], circularBufferForValue[readPointer]);

            // TODO: 28.05.2020 do we need to remove it?
            if (false) {
                circularBufferForKey[readPointer] = null;
                circularBufferForValue[readPointer] = null;
            }

            readPointer++;

            if (readPointer == circularBufferCapacity) {
                readPointer = 0;
            }
            circularBufferSize--;
        }
        //circularBufferSize = 0;
    }


    private void putInternal(Object key, Object value) {

        //Getting new position in hashmap
        final int hash = key.hashCode();
        final int pos = positiveModulo(hash, hashMapCapacity);


        if (keyStorage[pos] == null || valueStorage[pos] == null) {
            if (keyStorage[pos] != valueStorage[pos]) {
                throw new BrokenInvariantException("keyStorage[pos] != valueStorage[pos]");
            }
            keyStorage[pos] = new Object[INITIAL_LIST_SIZE];
            valueStorage[pos] = new Object[INITIAL_LIST_SIZE];
        }


        if (keyStorage[pos].length != valueStorage[pos].length) {
            throw new BrokenInvariantException("Collisions list must equals");
        }

        ensureCapacityFor(pos);
        int writePointer = writePointers[pos];

        keyStorage[pos][writePointer] = key;
        valueStorage[pos][writePointer] = value;

        writePointers[pos]++;

        reorganizeHashMap(getAndUpdateCapacity());
    }

    private int getAndUpdateCapacity() {
        int oldHashMapCapacity = hashMapCapacity;
        if (hashMapSize >= hashMapCapacity) {
            hashMapCapacity = increase(hashMapCapacity);
            keyStorage = Arrays.copyOf(keyStorage, hashMapCapacity);
            valueStorage = Arrays.copyOf(valueStorage, hashMapCapacity);
        }
        return oldHashMapCapacity;
    }

    private void reorganizeHashMap(int oldCapacity) {
        if (oldCapacity != hashMapCapacity) {
            //We need to reorganize only that keys/values where positiveModulo !=
            //Lazy delete - tombstone
            for (int pos = 0; pos < oldCapacity; pos++) {
                for (int row = 0; row < writePointers[pos]; row++) {

                    final Object curKeyType = keyStorage[pos][row];
                    final int hash = curKeyType.hashCode();
                    final int newPos = positiveModulo(hash, hashMapCapacity);
                    if (pos != newPos) {
                        putInternal(curKeyType, valueStorage[pos][row]);
                    }

                }
                //compress

            }
        }
        //moveCloserToStart();

    }

    private void ensureCapacityFor(int pos) {
        int pointer = writePointers[pos];
        if (pointer == valueStorage[pos].length) {
            pointer = increase(pointer);

            keyStorage[pos] = Arrays.copyOf(keyStorage[pos], pointer);
            valueStorage[pos] = Arrays.copyOf(valueStorage[pos], pointer);

            writePointers[pos] = pointer;
        }
    }


    private int positiveModulo(int hash, int modulo) {
        return (hash % modulo + modulo) % modulo;
    }

    @Override
    public int size() {
        return hashMapSize;
    }

    @Override
    public boolean isEmpty() {
        return hashMapSize == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            throw new BrokenInvariantException("null keys are not supported");
        }

        flushBuffer();

        final int hash = key.hashCode();
        final int pos = positiveModulo(hash, hashMapCapacity);
        if (valueStorage[pos] != null) {
            for (int row = 0; row < writePointers[pos]; row++) {
                if (key.equals(keyStorage[pos][row])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {

        flushBuffer();

        for (int pos = 0; pos < hashMapCapacity; pos++) {
            if (valueStorage[pos] != null) {
                int writePointer = writePointers[pos];
                for (int row = 0; row < writePointer; row++) {
                    if (Objects.equals(value, valueStorage[pos][row])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public ValueType get(Object key) {
        if (key == null) {
            throw new BrokenInvariantException("null keys are not supported");
        }


        flushBuffer();

        final int hash = key.hashCode();
        final int pos = positiveModulo(hash, hashMapCapacity);

        int amountOfValues = 0;
        Object result = null;
        if (valueStorage[pos] != null) {
            for (int row = 0; row < writePointers[pos]; row++) {
                if (Objects.equals(keyStorage[pos][row], key)) {
                    result = valueStorage[pos][row];
                    amountOfValues++;
                }
            }
            if (amountOfValues > 1) {
                for (int row = 0; row < writePointers[pos] && amountOfValues > 1; row++) {
                    if (Objects.equals(keyStorage[pos][row], key)) {
                        keyStorage[pos][row] = null;
                        valueStorage[pos][row] = null;
                        amountOfValues--;
                    }
                }
            }
        }

        return (ValueType) result;
    }


    @Override
    public ValueType remove(Object key) {
        if (key == null) {
            throw new BrokenInvariantException("null keys are not supported");
        }

        flushBuffer();

        final int hash = key.hashCode();
        final int pos = positiveModulo(hash, hashMapCapacity);

        Object result = null;
        if (valueStorage[pos] != null) {
            for (int row = 0; row < writePointers[pos]; row++) {
                if (Objects.equals(keyStorage[pos][row], key)) {

                    result = valueStorage[pos][row];

                    keyStorage[pos][row] = null;
                    valueStorage[pos][row] = null;
                }
            }
        }


        return (ValueType) result;
    }

    @Override
    public void putAll(Map<? extends KeyType, ? extends ValueType> m) {
        // TODO: 28.05.2020
    }

    @Override
    public void clear() {
        // TODO: 28.05.2020
    }

    @Override
    public Set<KeyType> keySet() {
        // TODO: 28.05.2020
        return null;
    }

    @Override
    public Collection<ValueType> values() {
        // TODO: 28.05.2020
        return null;
    }

    @Override
    public Set<Entry<KeyType, ValueType>> entrySet() {
        // TODO: 28.05.2020
        return null;
    }

    private static class BrokenInvariantException extends RuntimeException {
        public BrokenInvariantException(String message) {
            super(message);
        }
    }

    private static class UnsupportedFeatureException extends RuntimeException {
        public UnsupportedFeatureException(String message) {
            super(message);
        }

    }


    /**
     * Static methods
     */


    private static int increase(int oldSize) {
        return oldSize + (oldSize >> 1);
    }

    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2)) + 1;
    }

}
//Map<String, Object> 3462 - 1336 = 2126
//Map<String, String> 1336
//Map<Object, Object> = 3900 - 2126 - 1336 = 400
//Map<String, Integer> 65
//Map<Character, Object> 8