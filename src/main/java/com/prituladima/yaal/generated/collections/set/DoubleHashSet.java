package com.prituladima.yaal.generated.collections.set;

import com.prituladima.yaal.generated.collections.DoubleAbstractStream;
import com.prituladima.yaal.generated.collections.DoubleCollection;
import com.prituladima.yaal.generated.collections.hashing.DoubleHash;
import com.prituladima.yaal.generated.collections.iterator.DoubleIterator;
import com.prituladima.yaal.generated.collections.list.DoubleArray;
import com.prituladima.yaal.numbers.IntegerUtils;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 */
public class DoubleHashSet extends DoubleAbstractStream implements DoubleSet {
    private static final Random RND = new Random();
    private static final int[] SHIFTS = new int[4];
    private static final byte PRESENT_MASK = 1;
    private static final byte REMOVED_MASK = 2;

    static {
        for (int i = 0; i < 4; i++) {
            SHIFTS[i] = RND.nextInt(31) + 1;
        }
    }

    private int size;
    private int realSize;
    private double[] values;
    private byte[] present;
    private int step;
    private int ratio;

    public DoubleHashSet() {
        this(3);
    }

    public DoubleHashSet(int capacity) {
        capacity = Math.max(capacity, 3);
        values = new double[capacity];
        present = new byte[capacity];
        ratio = 2;
        initStep(capacity);
    }

    public DoubleHashSet(DoubleCollection c) {
        this(c.size());
        addAll(c);
    }

    public DoubleHashSet(double[] arr) {
        this(new DoubleArray(arr));
    }

    private void initStep(int capacity) {
        step = RND.nextInt(capacity - 2) + 1;
        while (IntegerUtils.gcd(step, capacity) != 1) {
            step++;
        }
    }

    @Override
    public DoubleIterator doubleIterator() {
        return new DoubleIterator() {
            private int position = size == 0 ? values.length : -1;

            public double value() throws NoSuchElementException {
                if (position == -1) {
                    advance();
                }
                if (position >= values.length) {
                    throw new NoSuchElementException();
                }
                if ((present[position] & PRESENT_MASK) == 0) {
                    throw new IllegalStateException();
                }
                return values[position];
            }

            public boolean advance() throws NoSuchElementException {
                if (position >= values.length) {
                    throw new NoSuchElementException();
                }
                position++;
                while (position < values.length && (present[position] & PRESENT_MASK) == 0) {
                    position++;
                }
                return isValid();
            }

            public boolean isValid() {
                return position < values.length;
            }

            public void remove() {
                if ((present[position] & PRESENT_MASK) == 0) {
                    throw new IllegalStateException();
                }
                present[position] = REMOVED_MASK;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(double value) {
        ensureCapacity((realSize + 1) * ratio + 2);
        int current = getHash(value);
        while (present[current] != 0) {
            if ((present[current] & PRESENT_MASK) != 0 && values[current] == value) {
                return;
            }
            current += step;
            if (current >= values.length) {
                current -= values.length;
            }
        }
        while ((present[current] & PRESENT_MASK) != 0) {
            current += step;
            if (current >= values.length) {
                current -= values.length;
            }
        }
        if (present[current] == 0) {
            realSize++;
        }
        present[current] = PRESENT_MASK;
        values[current] = value;
        size++;
    }

    private int getHash(double value) {
        int hash = DoubleHash.hash(value);
        int result = hash;
        for (int i : SHIFTS) {
            result ^= hash >> i;
        }
        result %= values.length;
        if (result < 0) {
            result += values.length;
        }
        return result;
    }

    private void ensureCapacity(int capacity) {
        if (values.length < capacity) {
            capacity = Math.max(capacity * 2, values.length);
            rebuild(capacity);
        }
    }

    private void squish() {
        if (values.length > size * ratio * 2 + 10) {
            rebuild(size * ratio + 3);
        }
    }

    private void rebuild(int capacity) {
        initStep(capacity);
        double[] oldValues = values;
        byte[] oldPresent = present;
        values = new double[capacity];
        present = new byte[capacity];
        size = 0;
        realSize = 0;
        for (int i = 0; i < oldValues.length; i++) {
            if ((oldPresent[i] & PRESENT_MASK) == PRESENT_MASK) {
                add(oldValues[i]);
            }
        }
    }

    @Override
    public boolean remove(double value) {
        int current = getHash(value);
        while (present[current] != 0) {
            if (values[current] == value && (present[current] & PRESENT_MASK) != 0) {
                present[current] = REMOVED_MASK;
                size--;
                squish();
                return true;
            }
            current += step;
            if (current >= values.length) {
                current -= values.length;
            }
        }
        return false;
    }

    @Override
    public boolean contains(double value) {
        int current = getHash(value);
        while (present[current] != 0) {
            if (values[current] == value && (present[current] & PRESENT_MASK) != 0) {
                return true;
            }
            current += step;
            if (current >= values.length) {
                current -= values.length;
            }
        }
        return false;
    }
}
