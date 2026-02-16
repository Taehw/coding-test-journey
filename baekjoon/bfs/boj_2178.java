package bfs;

import java.util.*;
import java.io.*;

public class boj_2178 {
    //미로탐색
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; //배열기준을 생각하기, dx와 dy의 조합이 상하좌우
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken(); //10110101 입력되면
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1)); //데이터를 하나씩 끊어서 넣어줌
            }
        }

        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) { //상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // depth update
                        queue.add(new int[] { x, y });
                    }
                }

            }
        }
    }
}
