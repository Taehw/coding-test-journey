package bfs_0x09;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_Self {

    static int n, m;
    static int[][] board;
    static boolean[][] vis;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y;


        public Point(int x, int y) { //public 빼먹음
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int startX, int startY) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY)); //new 빼먹음 ㅠ
        vis[startX][startY] = true;

        int area = 0;

        while (!q.isEmpty()) {

            Point cur = q.poll();
            area++;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                //nx = n일때 , 경계 검사
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                //방문했는지, 시작점인지?
                if (vis[nx][ny] || board[nx][ny] != 1) continue;

                vis[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }


        return area;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        vis = new boolean[n][m]; //모두 false 로 초기화

        //board 배열 입력로직
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //메인 로직
        int count = 0; //도형 개수 세기
        int maxArea = 0; //최대 넓이

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !vis[i][j]) {
                    count++;
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.newLine();
        bw.write(String.valueOf(maxArea));

        bw.flush();
        bw.close();
        br.close();
    }
}