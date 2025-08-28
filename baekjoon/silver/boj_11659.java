package silver;

import java.util.Scanner;

public class boj_11659 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        //합 배열 만들기
        int[] S = new int[N];

        S[0] = numbers[0];

        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + numbers[i];
        }


        for (int s : S) {
            System.out.println("s = " + s);
        }

        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            result[i] = S[end] - numbers[start];
        }

        for (int R : result) {
            System.out.println(R);
        }
    }
}
