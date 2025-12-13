package bronze.sorting;

import java.util.Scanner;

public class boj_2750 {

    //버블정렬
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        //버블정렬 구현
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) { //왜 i가 아니라 j일까
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j+1] = temp;
                }
            }
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
