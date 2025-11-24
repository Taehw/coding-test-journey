package silver.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11659_2 {

    public static void main(String[] args) throws IOException {
        //입력받아야하는 데이터가 큼 10만 10만 -> 빠르게 읽기위해 BufferReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int suNo = Integer.parseInt(st.nextToken()); //int 로 받아야되니까 Integer 파싱
        int quizNo = Integer.parseInt(st.nextToken());

        long[] S = new long[suNo+1];

        st = new StringTokenizer(br.readLine()); //?

        for (int i = 1; i <= suNo; i++) {
             S[i] = S[i-1] + Integer.parseInt(st.nextToken()); //입력받자마자 합배열 생성
        }

        //만들어진 합배열을 통해 질의에 대한 답을 출력
        for (int q = 0; q < quizNo; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(S[j] - S[i-1]);
        }
    }
}
