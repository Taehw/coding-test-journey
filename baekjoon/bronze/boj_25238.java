package bronze;

import java.util.Scanner;

public class boj_25238 {

    public static void main(String[] args) {

        //브론즈4 25238 - 사칙연산 문제
        Scanner sc = new Scanner(System.in);

        //a는 500이하, b는 100이하
        int a = sc.nextInt();
        int b = sc.nextInt();

        double defense_rate = (double)a * (100-b) / 100 ;

        System.out.println(defense_rate >= 100 ? 0 : 1);
    }
}
