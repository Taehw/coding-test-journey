package bfs_0x09;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1926번: 그림 (BFS)
 * - 강의 자료 19~22페이지에 해당하는 Java 전체 코드입니다. [cite: 529-668]
 */
public class BOJ_1926 {

    // 1. 전역 변수 선언 (N, M, 보드, 방문 배열, 방향 배열)
    static int n, m;
    static int[][] board;
    static boolean[][] vis;

    // 2. 방향 배열 (상하좌우)
    // C++ 코드와 달리 (1,0) (아래)부터 시작 [cite: 485]
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    /**
     * 3. 좌표(위치)를 저장하기 위한 static nested class (C++의 pair 역할) [cite: 408-413]
     */
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 4. 하나의 연결된 그림 영역의 넓이를 계산하는 BFS 함수
     * @param startX 시작점 X (행)
     * @param startY 시작점 Y (열)
     * @return 해당 그림의 넓이 (area)
     */
    public static int bfs(int startX, int startY) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        vis[startX][startY] = true; // 시작점 방문 처리

        int area = 0; // 현재 그림의 넓이

        while (!q.isEmpty()) {
            Point cur = q.poll();
            area++; // 큐에서 꺼낼 때마다 넓이 1 증가 [cite: 535]

            // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                // 경계(범위) 체크
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 방문 여부 및 그림(1) 여부 체크
                // (방문했거나 || 그림이 아니거나(0))
                if (vis[nx][ny] || board[nx][ny] != 1) continue;

                // 새 좌표 방문 처리 및 큐에 삽입
                vis[nx][ny] = true;
                q.add(new Point(nx, ny));
            }
        }
        return area; // 계산된 넓이 반환
    }

    /**
     * 5. 메인 함수 (입출력 및 전체 로직 처리)
     */
    public static void main(String[] args) throws IOException {
        // --- 빠른 입출력 ---
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // --- N, M 입력 ---
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // --- 배열 초기화 ---
        board = new int[n][m];
        vis = new boolean[n][m];

        // --- board 배열 입력 로직 ---
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); // 매 줄마다 새 Tokenizer
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // --- 메인 로직: 모든 칸을 순회하며 BFS 시작점 찾기 ---
        int count = 0; // 그림의 개수
        int maxArea = 0; // 가장 넓은 그림의 넓이

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // (i, j)가 그림(1)이고, 아직 방문 안 했다면 [cite: 538]
                if (board[i][j] == 1 && !vis[i][j]) {
                    count++; // 새 그림 발견, 개수 증가
                    // 해당 지점에서 BFS를 시작하고, 반환된 넓이로 최대값 갱신
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }

        // --- 결과 출력 ---
        bw.write(String.valueOf(count));   // 그림의 개수
        bw.newLine();                      // 줄바꿈
        bw.write(String.valueOf(maxArea)); // 가장 넓은 그림의 넓이

        bw.flush();
        bw.close();
        br.close();
    }
}