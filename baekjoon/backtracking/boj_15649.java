package backtracking;

import java.util.Scanner;

public class boj_15649 {

    //N과 M(1)

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //자연수 N, M
        N = sc.nextInt(); //N -> 수의 범위
        M = sc.nextInt(); //M -> 수열의 길이

        arr = new int[M];//수열을 저장할 배열
        visited = new boolean[N]; //방문여부를 check

        backtracking(0); //왜 0을 보냈지? 처음에는 비어있으니까? 그럼 위의 배열의 크기도 M+1이 되어야?
    }

    private static void backtracking(int length) {
        if (length == M) {
            printArray();
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[length] = i;
                backtracking(length + 1);
                visited[i] = false;
            }
        }

    }

    private static void printArray() {
        for (int i : arr) {
            System.out.print(i + 1 + " ");
        }
    }
}
