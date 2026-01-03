//백준 N과 M(4)
//내림차순 조건 추가, 수열의 다음 수는 이전수와 같거나 작어야함

package backtracking;

import java.io.*;
import java.util.*;

public class boj_15652 {

    //백트래킹 함수에서 써야하므로 static으로 메서드영역에서 관리
    static int[] seq; //수열을 저장할 배열
    static boolean[] visited; //방문여부를 저장할배열
    static int M;
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //N과 M 입력 받기
        seq = new int[M];
        visited = new boolean[N+1];
        sb = new StringBuilder();

        backtracking(0);

        System.out.println(sb);

    }

    private static void backtracking(int length) {

        if (length == M) {
            printSequence();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (length == 0) { //수열의 길이가 0일때는 1번째는 무조건 추가
                seq[length] = i;
                visited[i] = true;
                backtracking(length + 1);
                visited[i] = false;
            } else { //수열의길이 1이상일때는 내림차순 조건 검사 실행
                if(seq[length-1] <= i){ //내림차순 조건
                    seq[length] = i;
                    visited[i] = true;
                    backtracking(length + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static void printSequence() {
        for (int i = 0; i < M; i++) {
            sb.append(seq[i]).append(" ");
        }
        sb.append("\n");
    }
}
