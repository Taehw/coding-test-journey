package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class boj_15651 {

    //N과 M(3)

    static int[] seq;
    static boolean[] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new int[m];
        visited = new boolean[n + 1];

        backtracking(0);
    }

    private static void backtracking(int length) {

        if (length == m) {
            printArray();
            System.out.println();
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

        for (int number : seq) {
            System.out.print(number + " ");
        }
    }
}
