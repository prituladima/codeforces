import java.util.*;

public class C_2_B {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int i1 = 0; i1 < n; i1++) {
//                matrix[i][i1] = scanner.nextInt();
//            }
//        }
//

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            stringBuilder.append('R').append('D');
        }



        Map<String, Integer> map = new HashMap<>();

        char[] passes = stringBuilder.toString().toCharArray();

        //System.out.println(Arrays.toString(passes));

        while (nextPermutation(passes)) {
          //  System.out.println(Arrays.toString(passes));
        }
        System.out.println("DONE");


    }

    // Поиск очередной перестановки
    public static final boolean nextPermutation(char[] sequence) {
        // Этап № 1
        int i = sequence.length;
        do {
            if (i < 2)
                return false; // Перебор закончен
            --i;
        } while (sequence[i - 1] <= sequence[i]);
        // Этап № 2
        int j = sequence.length;
        while (i < j && sequence[i - 1] <= sequence[--j]) ;
        _swapItems(sequence, i - 1, j);
        // Этап № 3
        j = sequence.length;
        while (i < --j)
            _swapItems(sequence, i++, j);
        return true;
    }

    // Обмен значениями двух элементов последовательности
    private static final void _swapItems(char[] sequence, int index_0, int index_1) {
        char temp = sequence[index_0];
        sequence[index_0] = sequence[index_1];
        sequence[index_1] = temp;
    }

}