package com.prituladima.codeforce.a2oj.div2A;


import java.io.*;
import java.util.*;

/**
 * Created by prituladima on 6/28/18.
 */
public class Pro24 {

    private static class Dragon {

        int power;
        int bonus;

        public Dragon(int power, int bonus) {
            this.power = power;
            this.bonus = bonus;
        }

        public int getPower() {
            return power;
        }

        public int getBonus() {
            return bonus;
        }
    }

    private void solve() throws IOException {

        int s = nextInt(), n = nextInt();
        PriorityQueue<Dragon> pqBonus =
                new PriorityQueue<>(Comparator.comparingInt(Dragon::getBonus)
                        .thenComparing(Dragon::getPower).reversed());

        PriorityQueue<Dragon> pqPower =
                new PriorityQueue<>(Comparator.comparingInt(Dragon::getPower)
                        .thenComparing(Dragon::getBonus));

        for (int i = 0; i < n; i++) {
            pqBonus.add(new Dragon(nextInt(), nextInt()));
        }

        while (!pqBonus.isEmpty()){

            Dragon candidate = pqBonus.remove();
            if(candidate.getPower() < s){
                s+= candidate.getBonus();
            }else {
                pqPower.add(candidate);
            }
        }


        while (!pqPower.isEmpty()){
            Dragon candidate = pqPower.remove();
            if(candidate.getPower() < s){
                s += candidate.getBonus();
            }else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");


    }

    public static void main(String[] args) {
        new Pro24().run();
    }

    StringTokenizer tokenizer;
    BufferedReader reader;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    int[] nextArr(int size) throws NumberFormatException, IOException {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextInt();
        return arr;
    }

    long[] nextArrL(int size) throws NumberFormatException, IOException {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextLong();
        return arr;
    }

    double[] nextArrD(int size) throws NumberFormatException, IOException {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextDouble();
        return arr;
    }

}
