package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15650_refactor {

    static int N, M;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];

        // 1번 숫자부터 시작하라는 의미로 start = 1을 넘김
        backtracking(0, 1);
        System.out.println(sb);
    }

    // length: 현재 채운 개수 (depth)
    // start: 이번 칸에 채울 수 있는 숫자의 시작점
    private static void backtracking(int length, int start) {

        // 1. 종료 조건
        if (length == M) {
            for (int val : seq) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 2. 반복문 (start부터 시작하는 것이 핵심!)
        // visited 체크나, 이전 값과 비교하는 if문이 싹 사라짐
        for (int i = start; i <= N; i++) {
            seq[length] = i;

            // 다음 재귀 호출 때는 (현재 숫자 + 1)부터 시작하도록 전달
            backtracking(length + 1, i + 1);
        }
    }
}