package silver.binarySearch;

//백준1920 - 수 찾기
//N개의 정수가 주어질때 x라는 정수를 찾아내는 프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //이진탐색전 A배열 정렬해주기 - nlogn
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        //데이터 입력받음과 동시에 해당데이터에 대한 탐색 시작


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {

            int start = 0;
            int end = A.length - 1;

            boolean find = false;


            int x = Integer.parseInt(st.nextToken());

            while (start <= end) { //인덱스의 끝에 도닥하면 끝

                int mid_index = (start + end) / 2;
                int mid_value = A[mid_index];

                if (mid_value < x) { // x가 median 보다 작을때
                    start = mid_index + 1;

                } else if (mid_value > x) { //x가 median 보다 클때
                    end = mid_index - 1;

                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
