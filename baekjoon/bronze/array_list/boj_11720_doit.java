package bronze.array_list;

import java.util.Scanner;

public class boj_11720_doit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //입력값을 String 형 변수 sNum에 저장 후 char[]형 변수로 변환하기
        String sNum = sc.next();

        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0'; //cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적

        }
        System.out.println(sum);
    }
}
