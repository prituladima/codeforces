package com.prituladima.yaal.io;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import java.io.*;
import java.util.List;

/**
 *
 */
public class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void printTable(char[][] table) {
        for (char[] row : table) {
            printLine(new String(row));
        }
    }

    public void print(char[] array) {
        writer.print(array);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(array[i]);
        }
    }

    public void print(double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(array[i]);
        }
    }

    public void print(long[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(array[i]);
        }
    }

    public void printLine(int[] array) {
        print(array);
        writer.println();
    }

    public void printLine(double[] array) {
        print(array);
        writer.println();
    }

    public void printLine(long[] array) {
        print(array);
        writer.println();
    }

    public void printLine() {
        writer.println();
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void print(char i) {
        writer.print(i);
    }

    public void printLine(char i) {
        writer.println(i);
    }

    public void printLine(char[] array) {
        writer.println(array);
    }

    public void printFormat(String format, Object... objects) {
        writer.printf(format, objects);
    }

    public void close() {
        writer.close();
    }

    public void flush() {
        writer.flush();
    }

    public void print(long i) {
        writer.print(i);
    }

    public void printLine(long i) {
        writer.println(i);
    }

    public OutputWriter print(int i) {
        writer.print(i);
        return this;
    }

    public void printLine(int i) {
        writer.println(i);
    }

    public void separateLines(int[] array) {
        for (int i : array) {
            printLine(i);
        }
    }

    public void printList(List<?> answer) {
        for (Object o : answer) {
            printLine(o);
        }
    }

    public void printPairList(IntIntPair... answer) {
        for (IntIntPair pair : answer) {
            printLine(pair.first, pair.second);
        }
    }
}
