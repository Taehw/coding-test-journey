package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2475 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] number = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            sum += (int) Math.pow(number[i], 2);
        }

        int valNum = sum % 10;
        System.out.println(valNum);
    }

}