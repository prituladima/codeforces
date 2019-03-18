import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
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
        CNastyaTransponiruetMatricu solver = new CNastyaTransponiruetMatricu();
        solver.solve(1, in, out);
        out.close();
    }

    static class CNastyaTransponiruetMatricu {
        int n;
        int m;
        int[][] A;
        int[][] B;
        static int R = 3;
        static int C = 3;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            R = n = in.nextInt();
            C = m = in.nextInt();
            A = in.nextIntMatrix(n, m);
            B = in.nextIntMatrix(n, m);

//        HashMap<Integer, Integer> ms1 = new HashMap<>();
//        HashMap<Integer, Integer> ms2 = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                ms1.merge(A[i][j], 1, Integer::sum);
//                ms2.merge(B[i][j], 1, Integer::sum);
//            }
//        }

            out.printLine(rankOfMatrix(A) == rankOfMatrix(B) ? "YES" : "NO");

        }

        static void swap(int mat[][],
                         int row1, int row2, int col) {
            for (int i = 0; i < col; i++) {
                int temp = mat[row1][i];
                mat[row1][i] = mat[row2][i];
                mat[row2][i] = temp;
            }
        }

        static int rankOfMatrix(int mat[][]) {

            int rank = C;

            for (int row = 0; row < rank; row++) {

                // Before we visit current row
                // 'row', we make sure that
                // mat[row][0],....mat[row][row-1]
                // are 0.

                // Diagonal element is not zero
                if (mat[row][row] != 0) {
                    for (int col = 0; col < R; col++) {
                        if (col != row) {
                            // This makes all entries
                            // of current column
                            // as 0 except entry
                            // 'mat[row][row]'
                            double mult =
                                    (double) mat[col][row] /
                                            mat[row][row];

                            for (int i = 0; i < rank; i++)

                                mat[col][i] -= mult
                                        * mat[row][i];
                        }
                    }
                }

                // Diagonal element is already zero.
                // Two cases arise:
                // 1) If there is a row below it
                // with non-zero entry, then swap
                // this row with that row and process
                // that row
                // 2) If all elements in current
                // column below mat[r][row] are 0,
                // then remvoe this column by
                // swapping it with last column and
                // reducing number of columns by 1.
                else {
                    boolean reduce = true;

                    // Find the non-zero element
                    // in current column
                    for (int i = row + 1; i < R; i++) {
                        // Swap the row with non-zero
                        // element with this row.
                        if (mat[i][row] != 0) {
                            swap(mat, row, i, rank);
                            reduce = false;
                            break;
                        }
                    }

                    // If we did not find any row with
                    // non-zero element in current
                    // columnm, then all values in
                    // this column are 0.
                    if (reduce) {
                        // Reduce number of columns
                        rank--;

                        // Copy the last column here
                        for (int i = 0; i < R; i++)
                            mat[i][row] = mat[i][rank];
                    }

                    // Process this row again
                    row--;
                }

                // Uncomment these lines to see
                // intermediate results display(mat, R, C);
                // printf("\n");
            }

            return rank;
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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
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

        public int[][] nextIntMatrix(int rowCount, int columnCount) {
            int[][] table = new int[rowCount][];
            for (int i = 0; i < rowCount; i++) {
                table[i] = nextIntArray(columnCount);
            }
            return table;
        }

        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = nextInt();
            }
            return array;
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
}

