package bfs_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

    // 미로의 크기
    static int N;
    static int M;

    // 미로 상태 (1: 이동 가능, 0: 벽)
    static int[][] board;

    // 시작점으로부터의 최단 거리를 저장하는 배열 (방문 여부도 겸함)
    // dist[i][j] = -1 이면 아직 방문하지 않았음을 의미
    static int[][] dist;

    // 상하좌우 네 방향을 탐색하기 위한 배열
    // dx: 행(row)의 변화, dy: 열(col)의 변화
    static int[] dr = {1, 0, -1, 0}; // 아래, 오른쪽, 위, 왼쪽
    static int[] dc = {0, 1, 0, -1}; // 아래, 오른쪽, 위, 왼쪽

    // 큐에 넣을 좌표를 나타내는 클래스 (Pair 대신 사용)
    static class Point {
        int r, c; // 행(row), 열(col)

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dist = new int[N][M];

        // 1. 미로 데이터 입력 및 dist 배열 초기화
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
                dist[i][j] = -1; // -1로 초기화하여 미방문 상태 표시
            }
        }

        // 2. BFS 시작
        bfs(0, 0);

        // 3. 도착점 (N, M)의 최단 거리 출력. 
        // 배열 인덱스는 (N-1, M-1)
        System.out.println(dist[N - 1][M - 1]);
    }

    public static void bfs(int startR, int startC) {
        // Queue는 Point 객체를 저장
        Queue<Point> Q = new LinkedList<>();

        // 시작점 설정 (1, 1) -> 배열 인덱스 (0, 0)
        Q.offer(new Point(startR, startC));
        dist[startR][startC] = 1; // 시작 칸도 거리에 포함하므로 1로 시작

        while (!Q.isEmpty()) {
            Point cur = Q.poll();

            // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nxtR = cur.r + dr[dir];
                int nxtC = cur.c + dc[dir];

                // 1. 범위(Out Of Bounds) 체크
                if (nxtR < 0 || nxtR >= N || nxtC < 0 || nxtC >= M) {
                    continue;
                }

                // 2. 이동 가능한 칸(미로 값 1)인지 체크
                //    벽(0)이라면 이동 불가
                if (board[nxtR][nxtC] == 0) {
                    continue;
                }

                // 3. 이미 방문한 칸인지 체크 (dist[i][j] >= 1 이면 이미 방문)
                //    최단 거리는 처음 방문할 때 확정되므로 이미 방문했으면 넘어감
                if (dist[nxtR][nxtC] >= 1) {
                    continue;
                }

                // 모든 조건을 만족하면 큐에 넣고 거리 업데이트
                dist[nxtR][nxtC] = dist[cur.r][cur.c] + 1;
                Q.offer(new Point(nxtR, nxtC));
            }
        }
    }
}
