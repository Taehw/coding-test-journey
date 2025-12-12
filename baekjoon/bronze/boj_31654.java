package bronze;

import java.util.Scanner;

public class boj_31654 {

    public static void main(String[] args) {
        //브5 기본문제 - Adding Trouble
        //3개의 숫자를 입력받앗을때 처음입력받은 두개의 숫자의 합이 마지막으로 입력받은 숫자와 일치하는지 아닌지 확인하는 문제
        //각 숫자의 범위는 -10억 ~ 10억 -> int

        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int answer = sc.nextInt();

        if (answer == num1 + num2) {
            System.out.println("correct!");
        } else {
            System.out.println("wrong!");
        }
    }
}
