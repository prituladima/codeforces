package com.prituladima.codeforce;

import java.io.*;

/**
 * Created by prituladima on 9/2/18.
 */
public class CodeGen {


    public static void main(String[] args) throws IOException {
        final String NUMBER = "1040";
        final String PACKAGE = "com.prituladima.codeforce.virtual.contest" + NUMBER;
        final String DIR_PATH = "/home/prituladima/IdeaProjects/codeforces/src/main/java/com/prituladima/codeforce/virtual/contest" + NUMBER + "/";
        final String SRC =
                "package %s;\n" +
                        "import java.io.*;\n" +
                        "import java.util.*;\n" +
                        "\n" +
                        "import static java.lang.Double.parseDouble;\n" +
                        "import static java.lang.Integer.parseInt;\n" +
                        "import static java.lang.Long.parseLong;\n" +
                        "import static java.util.Arrays.stream;\n" +
                        "import static java.util.stream.IntStream.range;\n" +
                        "\n" +
                        "public final class %s {\n" +
                        "\n" +
                        "    private void solve() {\n" +
                        "\n" +
                        "        //put your code here\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "    public static void main(String[] args) {\n" +
                        "        new %s().run();\n" +
                        "    }\n" +
                        "\n" +
                        "    private BufferedReader reader;\n" +
                        "    private StringTokenizer tokenizer;\n" +
                        "    private PrintWriter writer;\n" +
                        "\n" +
                        "    private void run() {\n" +
                        "        try {\n" +
                        "            reader = new BufferedReader(new InputStreamReader(System.in));\n" +
                        "            tokenizer = null;\n" +
                        "            writer = new PrintWriter(System.out);\n" +
                        "            solve();\n" +
                        "            reader.close();\n" +
                        "            writer.close();\n" +
                        "        } catch (Exception e) {\n" +
                        "            e.printStackTrace();\n" +
                        "            System.exit(1);\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    private int nextInt() {\n" +
                        "        return parseInt(nextToken());\n" +
                        "    }\n" +
                        "\n" +
                        "    private long nextLong() {\n" +
                        "        return parseLong(nextToken());\n" +
                        "    }\n" +
                        "\n" +
                        "    private double nextDouble() {\n" +
                        "        return parseDouble(nextToken());\n" +
                        "    }\n" +
                        "\n" +
                        "    private int[] nextArr(int size) {\n" +
                        "        return stream(new int[size]).map(c -> nextInt()).toArray();\n" +
                        "    }\n" +
                        "\n" +
                        "    private long[] nextArrL(int size) {\n" +
                        "        return stream(new long[size]).map(c -> nextLong()).toArray();\n" +
                        "    }\n" +
                        "\n" +
                        "    private double[] nextArrD(int size) {\n" +
                        "        return stream(new double[size]).map(c -> nextDouble()).toArray();\n" +
                        "    }\n" +
                        "\n" +
                        "    private char[][] nextCharMatrix(int n) {\n" +
                        "        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);\n" +
                        "    }\n" +
                        "\n" +
                        "    private int[][] nextIntMatrix(final int n, final int m) {\n" +
                        "        return range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);\n" +
                        "    }\n" +
                        "\n" +
                        "    private double[][] nextDoubleMatrix(int n, int m) {\n" +
                        "        return range(0, n).mapToObj(i -> nextArr(m)).toArray(double[][]::new);\n" +
                        "    }\n" +
                        "\n" +
                        "    private String nextToken() {\n" +
                        "        while (tokenizer == null || !tokenizer.hasMoreTokens()) {\n" +
                        "            try {\n" +
                        "                tokenizer = new StringTokenizer(reader.readLine());\n" +
                        "            } catch (IOException e) {\n" +
                        "                throw new RuntimeException(e);\n" +
                        "            }\n" +
                        "        }\n" +
                        "        return tokenizer.nextToken();\n" +
                        "    }\n" +
                        "\n" +
                        "    private void souf(String format, Object... args) {\n" +
                        "        writer.printf(format, args);\n" +
                        "    }\n" +
                        "\n" +
                        "    private void sout(Object o) {\n" +
                        "        writer.print(o);\n" +
                        "    }\n" +
                        "\n" +
                        "    private void newLine() {\n" +
                        "        writer.println();\n" +
                        "    }\n" +
                        "\n" +
                        "    private void soutnl(Object o) {\n" +
                        "        sout(o);\n" +
                        "        newLine();\n" +
                        "    }\n" +
                        "\n" +
                        "    private int max(int a, int b) {\n" +
                        "        return Math.max(a, b);\n" +
                        "    }\n" +
                        "\n" +
                        "    private int min(int a, int b) {\n" +
                        "        return Math.min(a, b);\n" +
                        "    }\n" +
                        "\n" +
                        "}";

        for (char i = 'A'; i < 'H'; i++) {
            File file = new File(DIR_PATH + i + ".java");
            File parent = file.getParentFile();
            if (!parent.exists()) parent.mkdir();
            PrintWriter pw = new PrintWriter(file);
            pw.print(String.format(SRC, PACKAGE, String.valueOf(i), String.valueOf(i)));
            pw.close();

        }


    }

}