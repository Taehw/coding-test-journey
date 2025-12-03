package bronze.array_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10808_buff {

    //bufferedRedaer 버전
    //메모리 18236 -> 15828
    //시간   120ms -> 180ms
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String wordS = br.readLine();

        int[] alpNum = new int[26];
        char[] alp = wordS.toCharArray();

        for (char c : alp) {
            alpNum[c-97]++;
            //97대신 'a' 를 사용하는것도 하나의 방법
        }


        for (int i = 0; i < 26; i++) {
            System.out.print(alpNum[i] + " ");
        }
    }
}
