package com.prituladima.yaal.io;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import java.io.*;
import java.util.Collection;
import java.util.List;

public class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public OutputWriter printCharTable(char[][] table) {
        for (char[] row : table) {
            println(new String(row));
        }
        return this;
    }

    public OutputWriter print(char[] array) {
        writer.print(array);
        return this;
    }

    public OutputWriter print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
        return this;
    }

    public OutputWriter print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(array[i]);
        }
        return this;
    }

    public OutputWriter print(double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(array[i]);
        }
        return this;
    }

    public OutputWriter print(long[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(array[i]);
        }
        return this;
    }

    public OutputWriter println(int[] array) {
        print(array);
        writer.println();
        return this;
    }

    public OutputWriter println(double[] array) {
        print(array);
        writer.println();
        return this;
    }

    public OutputWriter println(long[] array) {
        print(array);
        writer.println();
        return this;
    }

    public OutputWriter println() {
        writer.println();
        return this;
    }

    public OutputWriter println(Object... objects) {
        print(objects);
        writer.println();
        return this;
    }

    public OutputWriter space() {
        writer.print(' ');
        return this;
    }

    public OutputWriter print(char i) {
        writer.print(i);
        return this;
    }

    public OutputWriter println(char i) {
        writer.println(i);
        return this;
    }

    public OutputWriter println(char[] array) {
        writer.println(array);
        return this;
    }

    public OutputWriter printf(String format, Object... objects) {
        writer.printf(format, objects);
        return this;
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }

    public OutputWriter print(long i) {
        writer.print(i);
        return this;
    }

    public OutputWriter println(long i) {
        writer.println(i);
        return this;
    }

    public OutputWriter print(int i) {
        writer.print(i);
        return this;
    }

    public OutputWriter printf(int i) {
        writer.println(i);
        return this;
    }

    public OutputWriter printArray(int[] array, char delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : array) stringBuilder.append(i).append(delimiter);
        if (delimiter == ' ') stringBuilder.append('\n');
        this.print(stringBuilder);
        return this;
    }

    public OutputWriter printArray(long[] array, char delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (long i : array) stringBuilder.append(i).append(delimiter);
        if (delimiter == ' ') stringBuilder.append('\n');
        this.print(stringBuilder);
        return this;
    }

    public OutputWriter printCollection(Collection<?> answer, char delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : answer) stringBuilder.append(o).append(delimiter);
        if (delimiter == ' ') stringBuilder.append('\n');
        this.print(stringBuilder);
        return this;
    }

    public OutputWriter printNoAns() {
        this.println(-1);
        return this;
    }
}
