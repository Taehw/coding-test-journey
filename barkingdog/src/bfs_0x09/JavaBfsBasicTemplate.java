package bfs_0x09;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JavaBfsBasicTemplate {


    //static 선언 -> main 및 bfs 함수에서 공통 사용
    static int n, m;
    static int[][] board;   //1: 파란 칸, 0: 빨간 칸
    static boolean[][] vis; //방문여부 체크

    //상하좌우 탐색을 위한 배열
    //C++ 코드와 다르게 (1,0), (0,1), (-1,0), (0,-1) 순서 (아래, 오른쪽, 위, 왼쪽)
    static int[] dx = {1, 0, -1, 0};//행
    static int[] dy = {0, 1, 0, -1};//열

    //좌표저장을 위한 Point 클래스
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // ---- 빠른 입출력 ----
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        vis = new boolean[n][m];

        //... (board 배열 입력받는 로직) ...

        //--- BFS 시작 ---
        Queue<Point> q = new LinkedList<>();

        //1. 시작점 (0,0)을 큐에 넣고 방문 처리
        q.add(new Point(0, 0));
        vis[0][0] = true;

        //2. 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            //3. 큐에서 원소 하나를 뽑음 (Dequeue)
            Point cur = q.poll();

            //방문 순서 출력 (디버기용)
            bw.write("(" + cur.x + ", " + cur.y + ") ->");

            //4. 4방향의 인접한 칸을 확인
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                //5-1 범위 체크
                //C++에서 처럼 이 순서가 바뀌면 ArrayIndexOutofBoundsException 발생!
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                //5-2 방문 여부 및 이동 가능 여부 체크
                //C++: (vis[nx][ny] || board[nx][ny] != 1)
                if(vis[nx][ny] || board[nx][ny] != 1) continue;;

                //6. (새로운 칸) 방문 처리 및 큐에 삽입(Enqueue)
                vis[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }

        bw.flush();
        bw.close();
        bw.close();
    }
}

