package bronze.array_list;

import java.util.Arrays;
import java.util.Scanner;

public class boj_10808 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String wordS = sc.next();

        int[] alpNum = new int[26];
        char[] alp = wordS.toCharArray();

        //a의 아스키 코드 -> 97 모든 아스키 코드 값
        //그럼 문자배열에서 97빼면 해당 배열에 접근할수 있겠네
        //끝났다

        for (char c : alp) {
            alpNum[c-97]++;
        }


        for (int i = 0; i < 26; i++) {
            System.out.print(alpNum[i] + " ");
        }
    }
}
