package silver.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1940_doit {

    public static void main(String[] args) throws IOException {
        //한줄로 숫자를 많이 받아야하기때문에 Buffered 사용
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int count = 0; //정답변수
        int i = 0; //A[0] -> Min
        int j = N-1; //A[N-1]

        while (i < j) {
            if (A[i] + A[j] < M) i++;
            else if(A[i] + A[j] > M) j--;
            else {
                count++;
                i++; j--;
            }
        }

        System.out.println(count);

    }
}
