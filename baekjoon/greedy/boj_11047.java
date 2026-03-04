package greedy;

//백준11047 - 동전개수의 최솟값 구하기 (실버4)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //동전의 종류
        int sum = Integer.parseInt(st.nextToken()); //목표합
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        } //데이터 입력 완료


        //그리디 알고리즘 구현
        int count = 0;

        for (int i = N-1; i >= 0; i--) { //for문 조건식 i는 0까지 검사해주기
            if (sum / coins[i] != 0) {
                count += sum / coins[i];
                sum = sum % coins[i];

                if (sum == 0) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
