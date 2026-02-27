package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {

    // 상하좌우 탐색을 위한 좌표
    static int[] dx = {0, 1, 0 , -1};
    static int[] dy = {1, 0, -1, 0};

    static int M, N; // M: 가로(열), N: 세로(행)
    static int[][] A;
    // 이 문제에서는 방문 배열(visited) 대신 원래 배열(A)에 일수를 누적하는 방식이 더 효율적입니다.
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 문제 입력 조건: M(가로), N(세로) 순서로 들어옵니다.
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        // 반복문 범위 수정: i < N (세로), j < M (가로)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 결과 출력
        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 1. 미로 범위를 벗어나지 않는지 확인
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 2. 안 익은 토마토(0)인 경우만 큐에 넣고 일수 증가
                    if (A[nx][ny] == 0) {
                        // 이전 토마토의 값(일수) + 1을 저장하여 날짜를 계산합니다.
                        A[nx][ny] = A[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // BFS 탐색 종료 후, 배열을 확인하여 정답 도출
        int maxDays = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 안 익은 토마토가 하나라도 남아있다면 -1 반환
                if (A[i][j] == 0) {
                    return -1;
                }
                // 가장 오래 걸린 일수 찾기
                maxDays = Math.max(maxDays, A[i][j]);
            }
        }

        // 처음부터 모든 토마토가 익어있던 상태라면 maxDays가 1입니다. 
        // 시작일이 1이었으므로 1을 빼줍니다.
        if (maxDays == 1) {
            return 0;
        } else {
            return maxDays - 1;
        }
    }
}