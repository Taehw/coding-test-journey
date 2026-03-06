package bfs;

//백준1697 - 숨바꼭질

import java.util.*;
import java.io.*;

public class boj_1697 {

    static int N, K;
    static int[] dist = new int[100001];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //수빈이의 위치 (1과 10만사이, 이동은 해당 범위 밖에 존재해도 상관없음)
        K = Integer.parseInt(st.nextToken()); //동생의 위치

        if (N == K) { //처음부터 위치가 같다면 움직일 필요가 없음
            System.out.println(0);
            return;
        }

        bfs(N);
    }

    private static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); //큐에 수빈이의 시작 위치 넣어줌

        while(!queue.isEmpty()) { //큐가 빌때까지

            int current = queue.poll(); //수빈이의 현재 위치

            //세 가지 이동 경로 탐색
            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) { //이동경로로 이동하면서 순회

                if (next >= 0 && next <= 100000 && dist[next] == 0) { //
                    queue.add(next);
                    dist[next] = dist[current] + 1;
                }

                //동생을 찾은 경우
                if (next == K) {
                    System.out.println(dist[next]);
                    return;
                }


            }
        }

    }
}
