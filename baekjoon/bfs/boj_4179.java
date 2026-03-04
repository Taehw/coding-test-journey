package bfs;

import java.io.*;
import java.util.*;

//백준4179 - 불! (BFS 응용)
public class boj_4179 {

    static int R, C;
    static char[][] maze;
    static int[][] fireTime; // 불이 도달하는 시간
    static int[][] jhTime;   // 지훈이가 도달하는 시간
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maze = new char[R][C];

        //각각을 분리해서 생각해야되기때문에 여러개의 2차원 배열이 필요
        fireTime = new int[R][C];
        jhTime = new int[R][C];

        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> jhQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = line.charAt(j);//해당인덱스에 있는 문자를 반환해서 배열에 채워넣어줌
                // 방문 배열 겸 시간 저장 배열 초기화 (-1은 미방문 상태)
                fireTime[i][j] = -1;
                jhTime[i][j] = -1;

                if (maze[i][j] == 'F') {
                    fireQueue.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                } else if (maze[i][j] == 'J') {
                    jhQueue.offer(new int[]{i, j});
                    jhTime[i][j] = 0;
                }
            }
        }

        // 1. 불에 대한 BFS (불이 각 칸에 도달하는 시간 계산)
        while (!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 범위 내에 있고, 벽이 아니며, 아직 불이 번지지 않은 곳
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (maze[nr][nc] != '#' && fireTime[nr][nc] == -1) {
                        fireTime[nr][nc] = fireTime[r][c] + 1;
                        fireQueue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        // 2. 지훈이(J)에 대한 BFS (탈출 경로 탐색)
        while (!jhQueue.isEmpty()) {
            int[] cur = jhQueue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 미로의 범위를 벗어났다 == 탈출에 성공했다
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    System.out.println(jhTime[r][c] + 1);
                    return; // 최단 시간이므로 바로 종료
                }

                // 벽이 아니고, 지훈이가 방문한 적 없는 곳
                if (maze[nr][nc] != '#' && jhTime[nr][nc] == -1) {
                    // 핵심 조건: 불이 아예 도달하지 않는 곳이거나(-1), 지훈이가 불보다 '먼저' 도착하는 곳만 이동 가능
                    if (fireTime[nr][nc] == -1 || fireTime[nr][nc] > jhTime[r][c] + 1) {
                        jhTime[nr][nc] = jhTime[r][c] + 1;
                        jhQueue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        // 큐가 빌 때까지 범위를 벗어나지 못했다면 탈출 불가
        System.out.println("IMPOSSIBLE");
    }
}