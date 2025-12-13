package bronze;

import java.util.Scanner;

public class boj_27890 {

    public static void main(String[] args) {

        //브론즈4 - 특별한 작은 분수
        //백준 노트를 확인하자 -> 문제해석에 대한 도움이 나와있다
        Scanner sc = new Scanner(System.in);
        int x0 = sc.nextInt();
        int N = sc.nextInt();
        int xN = 0;

        if (N == 0) {
            System.out.println(x0);
        } else {
            for (int i = 0; i < N; i++) {
                if (x0 % 2 == 0) {
                    xN = (x0 / 2) ^ 6;
                    x0 = xN;
                } else {
                    xN = (2 * x0) ^ 6;
                    x0 = xN;
                }
            }
            System.out.println(xN);
        }
    }
}
