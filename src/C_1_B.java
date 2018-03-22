import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * Created by prituladima on 3/21/18.
 */
public class C_1_B {

    public static void main(String[] args) throws Exception{

        Scanner scanner = new Scanner(new File("input.txt"));

        int n = scanner.nextInt();scanner.nextLine();
        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            String str = array[i] = scanner.nextLine();
            System.out.println(str);
            if (str.matches("R[0-9]+C[0-9]+")) {
                int r = Integer.parseInt(str.substring(1, str.indexOf('C')));
                int c = Integer.parseInt(str.substring(str.indexOf('C')));
                convert(r, c);
            }
        }

//        System.out.println("BC23");
//        System.out.println("R23C55");

    }

    private static String convert(int r, int c) {
        System.out.printf("%s - %s", r, c);
        return "";
    }
}
