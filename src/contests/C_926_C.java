package contests;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by prituladima on 3/20/18.
 */
public class C_926_C {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(array[i] = scanner.nextInt());
        }

        if(set.size() == 1){
            System.out.println("YES");
            return;
        }






    }

}
