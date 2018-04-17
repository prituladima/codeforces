import java.util.*;

public class TaskA {

    public static void main(String[] args) {
        new TaskA().solve();
    }

    TaskA() {
    }

    private void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n / 2 + 1);
    }

}