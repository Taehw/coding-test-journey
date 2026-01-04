//백준 15656 - N과 M(7)
//중복 선택 가능

package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15656 {

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
        }

        Arrays.sort(numbers);  //입력후 정렬까지 완료

        backtracking(0, 0);

        System.out.println(sb);
    }

    private static void backtracking(int start, int length) {

        if (length == M) {
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i < N; i++) {
            seq[length] = numbers[i];
            backtracking(start, length + 1);
        }
    }
}
