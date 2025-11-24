package silver.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11659_doit_answer {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken()); //숫자의 개수 - int로 받아야하기 때문에 파싱 굳
        int quizNo = Integer.parseInt(stringTokenizer.nextToken()); //질의의 개수

        //합배열은 구현이 쉬움 -> 들어오자마자 합배열 만들어주기
        long[] S = new long[suNo + 1]; //0번째 인덱스를 무시하기 위해서 +1
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i<= suNo; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int q = 0; q <= quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(S[j] - S[i - 1]);
        }

    }
}