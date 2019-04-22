import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Random;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author dmytro.prytula prituladima@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        IOniPovsyudu solver = new IOniPovsyudu();
        solver.solve(1, in, out);
        out.close();
    }

    static class IOniPovsyudu {
        int n;
        char[] s;
        static final int no_of_chars = 256;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            s = in.nextToken().toCharArray();
            out.printLine(findSubString(String.valueOf(s), String.valueOf(GeekInteger.uniq(s))).length());
        }

        static String findSubString(String str, String pat) {
            int len1 = str.length();
            int len2 = pat.length();

            // check if string's length is less than pattern's
            // length. If yes then no such window can exist
            if (len1 < len2) {
                System.out.println("No such window exists");
                return "";
            }

            int hash_pat[] = new int[no_of_chars];
            int hash_str[] = new int[no_of_chars];

            // store occurrence ofs characters of pattern
            for (int i = 0; i < len2; i++)
                hash_pat[pat.charAt(i)]++;

            int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

            // start traversing the string
            int count = 0; // count of characters
            for (int j = 0; j < len1; j++) {
                // count occurrence of characters of string
                hash_str[str.charAt(j)]++;

                // If string's char matches with pattern's char
                // then increment count
                if (hash_pat[str.charAt(j)] != 0 &&
                        hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
                    count++;

                // if all the characters are matched
                if (count == len2) {
                    // Try to minimize the window i.e., check if
                    // any character is occurring more no. of times
                    // than its occurrence in pattern, if yes
                    // then remove it from starting and also remove
                    // the useless characters.
                    while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]
                            || hash_pat[str.charAt(start)] == 0) {

                        if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
                            hash_str[str.charAt(start)]--;
                        start++;
                    }

                    // update window size
                    int len_window = j - start + 1;
                    if (min_len > len_window) {
                        min_len = len_window;
                        start_index = start;
                    }
                }
            }

            // If no window found
            if (start_index == -1) {
                System.out.println("No such window exists");
                return "";
            }

            // Return substring starting from start_index
            // and length min_len
            return str.substring(start_index, start_index + min_len);
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public OutputWriter printLine(int i) {
            writer.println(i);
            return this;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextToken() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        private static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class GeekInteger {
        public static char[] shuffle(char[] array) {
            int n = array.length;
            Random random = new Random();
            for (int i = 0, j; i < n; i++) {
                j = i + random.nextInt(n - i);
                char randomElement = array[j];
                array[j] = array[i];
                array[i] = randomElement;
            }
            return array;
        }

        public static char[] uniq(char[] arr) {
            arr = arr.clone();
            shuffle(arr);
            Arrays.sort(arr);
            int pos = 0;
            arr[pos++] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    arr[pos++] = arr[i];
                }
            }
            return Arrays.copyOf(arr, pos);
        }

    }
}

