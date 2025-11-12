package bfs_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2718_self {

    static int n, m;
    static int[][] board;
    static int[][] dist;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
                dist[i][j] = -1;
            }
        }

        bfs(0, 0);

        System.out.println(dist[n - 1][m - 1]);
    }


    public static void bfs(int startX, int startY){

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        dist[startX][startY] = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                //
                if(board[nx][ny] == 0) continue;

                if(dist[nx][ny] >= 1) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Point(nx, ny));

            }
        }


    }
}
