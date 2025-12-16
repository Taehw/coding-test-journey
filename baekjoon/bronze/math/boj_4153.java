package bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class boj_4153 {

    /*

    개선할점
    1. Math.pow() 대신 직접 곱하기 사용
    2. 배열 굳이 사용안해됨
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int[] triLen = new int[3];

            StringTokenizer st = new StringTokenizer(br.readLine());

            triLen[0] = Integer.parseInt(st.nextToken());
            triLen[1] = Integer.parseInt(st.nextToken());
            triLen[2] = Integer.parseInt(st.nextToken());

            if (triLen[0] == 0 && triLen[1] == 0 && triLen[2] == 0) {
                break;
            }

            Arrays.sort(triLen);

            if (pow(triLen[2], 2) == pow(triLen[1], 2) + pow(triLen[0], 2)) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }

        System.out.println(sb);
    }
}
