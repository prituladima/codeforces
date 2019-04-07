package com.prituladima.yaal.io;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import java.io.*;
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
            printLine(new String(row));
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

    public OutputWriter printLine(int[] array) {
        print(array);
        writer.println();
        return this;
    }

    public OutputWriter printLine(double[] array) {
        print(array);
        writer.println();
        return this;
    }

    public OutputWriter printLine(long[] array) {
        print(array);
        writer.println();
        return this;
    }

    public OutputWriter printLine() {
        writer.println();
        return this;
    }

    public OutputWriter printLine(Object... objects) {
        print(objects);
        writer.println();
        return this;
    }

    public OutputWriter printSpace() {
        writer.print(' ');
        return this;
    }

    public OutputWriter print(char i) {
        writer.print(i);
        return this;
    }

    public OutputWriter printLine(char i) {
        writer.println(i);
        return this;
    }

    public OutputWriter printLine(char[] array) {
        writer.println(array);
        return this;
    }

    public OutputWriter printFormat(String format, Object... objects) {
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

    public OutputWriter printLine(long i) {
        writer.println(i);
        return this;
    }

    public OutputWriter print(int i) {
        writer.print(i);
        return this;
    }

    public OutputWriter printLine(int i) {
        writer.println(i);
        return this;
    }

    public void separateLines(int[] array) {
        for (int i : array) {
            this.printLine(i);
        }
    }

    public void printList(List<?> answer) {
        for (Object o : answer) {
            this.printLine(o);
        }
    }

    public void printPairList(IntIntPair... answer) {
        for (IntIntPair pair : answer) {
            this.printLine(pair.first, pair.second);
        }
    }

    public void printNoAns() {
        this.printLine(-1);
    }
}
