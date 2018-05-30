package com.prituladima.contests;

import java.util.Scanner;

public class C_1_B {

    public static void main(String[] args) throws Exception {

//        Scanner scanner = new Scanner(new File("input.txt"));
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] array = new String[n];


        for (int i = 0; i < n; i++) {
            String str = array[i] = scanner.nextLine();
            if (str.matches("R[0-9]+C[0-9]+")) {
                long r = Long.parseLong(str.substring(1, str.indexOf('C')));
                long c = Long.parseLong(str.substring(str.indexOf('C') + 1));
                System.out.println(convert1(r, c));
            } else {
                int numPos = 0;
                char[] chars = str.toCharArray();
                for (int i1 = 0; i1 < chars.length; i1++)
                    if(Character.isDigit(chars[numPos = i1])) break;

                String AB = str.substring(0, numPos);
                long number = Long.parseLong(str.substring(numPos));

                System.out.println("R" + number +  "C" + convert2(AB));

            }
        }
    }

    private static String convert1(long r, long c) {
        String columnString = "";
        long columnNumber = c;
        while (columnNumber > 0)
        {
            long currentLetterNumber = (columnNumber - 1) % 26;
            char currentLetter = (char)(currentLetterNumber + 65);
            columnString = currentLetter + columnString;
            columnNumber = (columnNumber - (currentLetterNumber + 1)) / 26;
        }
        return columnString + r;
    }

    private static long convert2(String str){
        StringBuilder s = new StringBuilder().append(str).reverse();
        char[] chars = s.toString().toCharArray();
        long counter = 0;

        for (int i = 0; i < chars.length; i++) {
            counter += to10(chars[i])*Math.pow(26, i);
        }

        return counter;
    }

    private static int to10(char a) {
        return a - 'A' + 1;
    }



}