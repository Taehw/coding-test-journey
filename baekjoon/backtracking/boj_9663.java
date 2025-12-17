package backtracking;

import java.util.Scanner;

public class boj_9663 {

    static int N;
    static int[] board;
    static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N]; //가독성 높일려면 N+1 해서 0버리고 쓰는것도 ㄱㅊ할듯

        backtracking(0);
        System.out.println(count);
    }

    private static void backtracking(int row) {

        if (row == N ) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) { //모든 경우의 수 탐색
            board[row] = i;
            if (check(row)) { //가지치기 유효성 검사
                backtracking(row + 1);
            }
        }
    }

    /*
    * N = 4
    * board -> 5개
    *
    * 0 1 2 3 4 -> backtracking 처음 매개변수로 1 넘겨주면 1부터 쓸수 있음
    *
    * */
    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if(board[i] == board[row]) return false;
            if(Math.abs(row - i) == Math.abs(board[row] - board[i])) return false;
        }
        return true;
    }
}
