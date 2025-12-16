package dfs;

import java.io.*;
import java.util.*;

public class boj_11724_self {

    //인접리스트 A는 static으로 선언 불변하니까
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정점의 개수 n, 간선의 개수 m
        //n, m 입력 받고
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //인접리스트를 위한 배열 A -> A는 node의 크기만큼 초기화 (0번째 배열 제외하고 1부터 시작하고
        //이부분 계속 헷갈리네
        //각 배열안은 ArrayList로 시작점과 이어진 node들이 담길수 있도록 해야될듯

        A = new ArrayList[n+1];
        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        //방문배열 visited[] - 노드의 개수만큼
        visited = new boolean[n+1];

        //for(i : m번 만큼){
        //    간선의 양끝점 입력받기 u,v
        //    양끝점 인접리스트에 넣어주기 (이때 방향x -> 양쪽다 넣어주기)
        //}
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A[u].add(v);
            A[v].add(u);
        } //인접리스트 완성

        //DFS 돌아야지
        /*
         for (i는 n만큼 반복)
        if(방문하지않는 시작노드가 있다면)
        visited -> true
        DFS
         */
        int count = 0;

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    public static void DFS(int startPoint) {
        //DFS 함수 -> 연결요소의 개수 ++ , 재귀로 탐색 ???
        visited[startPoint] = true;

        for (int i : A[startPoint]) {
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
