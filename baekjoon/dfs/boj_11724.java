package dfs;

import java.io.*; //근데 필요한라이브러리외에 가져오면 실행시간에 영향 안미치나?
import java.util.*;

public class boj_11724 {

    static boolean[] visited;
    static ArrayList<Integer>[] A;
    //백준 11724 - 연결 요소의 개수 (S2)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정점의 개수 N과 간선의 개수 M 입력받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //방문여부 체크 배열
        visited = new boolean[n+1]; //이거 static 으로 넣으려면 어떻게 해야되지?
        //인접리스트 자료구조 - 각 배열은 나중에 ArrayList로 초기화
        A = new ArrayList[n+1];

        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>();
        }
        //입력받은 간선의 양끝점을 인접리스트에 입력해주기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //이때 양끝점에 대한 방향이 안주어졌으므로 두개다 넣어줘야댐
            A[u].add(v);
            A[v].add(u);
        }

        int count = 0; //연결요소 개수를 세기위한 count 변수

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    public static void DFS(int startPoint) {
        if (visited[startPoint]) {
            return ;
        } //없어도 되는부분

        visited[startPoint] = true;
        for (int i : A[startPoint]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
