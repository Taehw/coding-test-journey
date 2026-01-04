package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15654 {

    static int[] numbers;
    static boolean[] visited; //중복출력 방지를 위한 방문체크 수열
    static int[] seq;

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //입력될 자연수의 개수
        M = Integer.parseInt(st.nextToken()); //수열의 길이

        numbers = new int[N]; //자연수를 저장할 배열
        visited = new boolean[N];
        seq = new int[M];

        st = new StringTokenizer(br.readLine()); //token 초기화
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers); //사전순 출력을 위한 정렬

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
            if (!visited[i]) {
                seq[length] = numbers[i];
                visited[i] = true;
                backtraking(length + 1);
                visited[i] = false;
            }
        }
    }
}
