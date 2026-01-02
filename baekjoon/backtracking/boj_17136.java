package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 - 색종이 붙이기
public class boj_17136 {

    //backtraking 함수에서 같이 써야하는 변수들
    static int[][] M = new int[10][10];
    static int[] S = {0, 5, 5, 5, 5, 5}; //0*0색종이 빼고 1*1 색종이부터
    static int result = Integer.MAX_VALUE; //???

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtraking(0, 0); //매개변수 : 좌표, 사용한 색종이 개수
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1 );
        } else {
            System.out.println(result);
        }
    }

    private static void backtraking(int xy, int useCnt) {
        //정답처리
        if (xy == 100) { //xy가 99에서 +1 되서 100이면 다 돌았다는 거니까 탈출조건으로 xy==100을 설정
            result = Math.min(result, useCnt);
            return;
        }
        //하나의 정수값으로 xy좌표 표현하기(tip)
        int x = xy % 10;
        int y = xy / 10;

        if(result <= useCnt) return;
        if (M[y][x] == 1) {
            for (int i = 5; i > 0; i--) { //큰 색종이부터 탐색하기로 했으니까 5부터
                if(S[i] > 0 && check(x, y, i)) {
                    S[i]--;
                    fill(x, y, i, 0); //색종이 붙이기, i는 색종이의 크기
                    backtraking(xy+1, useCnt+1);
                    fill(x, y, i, 1); //색종이를 떼기 - 위의 반대되는 동작이지만 하나의 함수(fill)로 처리 가능
                    S[i]++;
                }
            }
        } else {
            //0인경우 - 탐색 필요 x 그냥 바로 다음칸으로
            backtraking(xy+1, useCnt);
        }
    }



    private static void fill(int x, int y, int size, int num) {
        //색종이의 크기만큼 붙여주기
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                M[i][j] = num;
            }
        }
    }

    private static boolean check(int x, int y, int size) {

        if(x + size > 10 || y+size > 10) return false;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if( M[i][j] != 1) {
                    return false;
                }
            }
        }

        return true; //색종이 붙여도 됌
    }
}
