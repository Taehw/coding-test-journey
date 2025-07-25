package bronze;

import java.util.Scanner;

public class boj_10871 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int i = 0;
        while (i < n) {
            int num = scanner.nextInt();
            if (num < x) {
                System.out.print(num + " ");
            }
            i++;
        }
    }
}
