package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15650 {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    //N과 M(2)
    //이번엔 BufferedReader와 StringBuilder를 사용해보자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1]; //이것도 1부터 사용하자
        seq = new int[M]; //1부터 사용하게

        backtracking(0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int length) {
        if (length == M) {
            printArray();

            return ;
        }

        for (int i = 0; i < N; i++) {
            if (length == 0) {
                if (!visited[i]) {
                    visited[i] = true;
                    seq[length] = i;
                    backtracking(length+1);
                    visited[i] = false;
                }
            } else {
                if (!visited[i] && i > seq[length - 1]) {
                    visited[i] = true;
                    seq[length] = i;
                    backtracking(length+1);
                    visited[i] = false;
                }
            }

        }
    }

    private static void printArray() {
        for (int i : seq) {
            sb.append(i + 1).append(" ");
        }
        sb.append("\n");
    }
}
