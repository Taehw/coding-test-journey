package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15655 {

    static int[] numbers;
    static int N;
    static int M;
    static boolean[] visted;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visted = new boolean[N]; //방문체크 배열
        seq = new int[M]; //수열저장할 배열
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers); //오름차순 정렬
        //데이터 입력완료

        backtraking(0);

        System.out.println(sb);
    }

    private static void backtraking(int length) {

        if (length == M) {
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visted[i]) {
                seq[length] = numbers[i];

                for (int j = 0; j <= i; j++) {
                    visted[j] = true;
                }

                backtraking(length + 1);

                for (int j = 0; j <= i; j++) {
                    visted[j] = false;
                }
            }
        }
    }
}
