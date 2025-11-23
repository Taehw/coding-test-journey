package bronze.array_list;

import java.util.Scanner;

public class boj_11720_3 {

    public static void main(String[] args) {

        //숫자의 개수 100까지 -> int, long x -> String
        //숫자 N개가 공백없이
        //나머지 연산을 통해 각자리수 구하기? -> 너무 복잡
        //toCharArray와 아스키코드 연산


        Scanner input = new Scanner(System.in);
        //N을 입력
        int count = input.nextInt();
        //문자열 입력
        String numbers = input.next();
        //문자열 toCharArray
        char[] chars = numbers.toCharArray();
        //sum 변수 선언
        int sum = 0;
        //sum 에 문자 배열의 값을 아스키코드 연산을 통해 정수로 변환후 계산
        for(int i = 0 ; i < count ; i++){
            sum += chars[i] - '0';
        }

        System.out.println(sum);
    }
}
