package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class boj_15651 {

    //N과 M(3)

    static int[] seq;
    static boolean[] visited;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new int[m];
        visited = new boolean[n + 1]; //방문배열 체크시 가독성을 위해 크기는 n이 아닌 n+1로 선언 0이 아니라 1부터시작해서 읽기 좋음

        backtracking(0);

        System.out.println(sb);
    }

    private static void backtracking(int length) {

        if (length == m) {
            printArray();
            return;
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            seq[length] = i;
            backtracking(length + 1);
            visited[i] = false;
        }
    }

    private static void printArray() {
        for (int i = 0; i < m; i++) {
            sb.append(seq[i]).append(" ");
        }
        sb.append("\n");
    }
}
