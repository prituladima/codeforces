package contests;

import java.util.Arrays;
import java.util.Scanner;

public class C_926_B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] coordinates = new int[m];

        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = sc.nextInt();
        }

        Arrays.sort(coordinates);

        if (coordinates[0] < 0) {
            int dif = Math.abs(coordinates[0]);
            for (int i = 0; i < coordinates.length; i++) {
                coordinates[i] += dif;
            }
        }

        int[] segments = new int[m - 1];
        int sum = 0;
        for (int i = 0; i < segments.length; i++) {
            sum += segments[i] = coordinates[i + 1] - coordinates[i];
        }

//        System.out.println(segments);

//        System.out.println(sum);
        int GCD = 0;


        //
        //GCD
        GCD = gcd_array(segments);
//        System.out.println("GCD");
//        System.out.println(GCD);
        //


        int r = sum / GCD + 1 - m;

        System.out.println(r);

    }

    static int gcd_array(int... array) {

        int length = array.length;
        if(length == 2) return gcd(array[0], array[1]);
        if(length == 1) return array[0];

        int[] part1 = Arrays.copyOfRange(array, 0, length/2);
        int[] part2 = Arrays.copyOfRange(array, length/2 , length);
//        System.out.println(Arrays.toString(array));
//        System.out.println(length);
//        System.out.println(Arrays.toString(part1));
//        System.out.println(Arrays.toString(part2));
        return gcd(gcd_array(part1), gcd_array(part2));
    }

    static int gcd(int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;
        if (m == n) return m;
        if (m == 1) return 1;
        if (n == 1) return 1;

        if (m % 2 == 0 && n % 2 == 0) return 2 * gcd(m / 2, n / 2);
        if (m % 2 == 0 && n % 2 != 0) return gcd(m / 2, n);
        if (m % 2 != 0 && n % 2 == 0) return gcd(m, n / 2);

        if (m % 2 != 0 && n % 2 != 0 && n > m) return gcd((n - m) / 2, m);
        if (m % 2 != 0 && n % 2 != 0 && n < m) return gcd((m - n) / 2, n);

        return 0;
    }

//    НОД(0, n) = n; НОД(m, 0) = m; НОД(m, m) = m;
//    НОД(1, n) = 1; НОД(m, 1) = 1;
//    Если m, n чётные, то НОД(m, n) = 2*НОД(m/2, n/2);
//    Если m чётное, n нечётное, то НОД(m, n) = НОД(m/2, n);
//    Если n чётное, m нечётное, то НОД(m, n) = НОД(m, n/2);
//    Если m, n нечётные и n > m, то НОД(m, n) = НОД((n-m)/2, m);
//    Если m, n нечётные и n < m, то НОД(m, n) = НОД((m-n)/2, n);

}
