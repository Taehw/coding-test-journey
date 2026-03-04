package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15657 {

    static int N;
    static int M;
    static int[] numbers;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        seq = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        } //데이터 입력 완료

        Arrays.sort(numbers); //사전순 출력을 위한 정렬

        backtraking(0, 0);
    }

    private static void backtraking(int start, int length) {

        if (length == M) {
            for (int i = 0; i < M; i++) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        for (int i = start; i < N; i++) {
            seq[length] = numbers[i];
            backtraking(start, length+1);
        }
    }
}
