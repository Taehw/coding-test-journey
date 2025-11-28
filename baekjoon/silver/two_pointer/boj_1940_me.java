package silver.two_pointer;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1940_me {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr_stuff = new int[N];

        for (int i = 0; i < N; i++) {
            arr_stuff[i] = sc.nextInt();
        }

        Arrays.sort(arr_stuff);

        int start_index = 0;
        int end_index = N-1;
        int count = 0;

        while (start_index < end_index) {

            int sum_stuff = arr_stuff[start_index] + arr_stuff[end_index];
            if (sum_stuff < M) {
                start_index++;
            } else if (sum_stuff > M) {
                end_index--;
            } else {
                count++;
                start_index++;
                end_index--;
            }
        }

        System.out.println(count);
    }
}
