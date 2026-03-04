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

        BFS(0, 0); //탐색 시작
        System.out.println(A[N-1][M-1]); //해당 배열의 값을 depth 값으로 바꿔놨기 때문에 바로 출력
    }

    //핵심
    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>(); //queue 자료구조 형태로 구현

        queue.offer(new int[]{i, j}); //0,0부터 탐색 시작
        while (!queue.isEmpty()) { //queue에 값이 남아있다면 계속진행 = queue 가 비워지때까지

            int[] now = queue.poll(); //queue에서 값을꺼내서 현재 위치 할당

            visited[i][j] = true; //해당 위치 방문처리

            //bfs 에서 개념에서 봤던 그래프를 연결리스트의 구조로 변환하는 과정
            for (int k = 0; k < 4; k++) { //상하좌우 탐색
                int x = now[0] + dx[k]; //now[0]은 queue에서 꺼낸 {0,0}의 앞의 값
                int y = now[1] + dy[k]; //now[1]은 queue에서 꺼낸 {0,0}의 뒤의 값
                //for문을 돌면서 현재 위치 기준 위의 코드를 통해 상하좌우를 탐색하게됨

                if (x >= 0 && y >= 0 && x < N && y < M) { //x, y가 그니까 배열의 값의 범위일때
                    if (A[x][y] != 0 && !visited[x][y]) { //방문하지 않는 위치고, 해당 배열의 값이 0이 아니라면(우리는 1만 통과할수 있으니까
                        visited[x][y] = true; //해당 위치 방문 처리하고
                        A[x][y] = A[now[0]][now[1]] + 1; // depth update
                        queue.add(new int[] { x, y }); //방문한 1의 위치는 queue에 추가
                    }
                }

            }
        }
    }
}
