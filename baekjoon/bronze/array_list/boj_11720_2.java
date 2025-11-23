package bronze.array_list;

import java.util.Scanner;

public class boj_11720_2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int count = input.nextInt();
        String numbers = input.next();//입력받는 숫자의 값이 100 이상인 경우 고려 int, long x -> String
        char[] num_list = numbers.toCharArray();

        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum += num_list[i] - '0';
        }

        System.out.println(sum);

    }
}
