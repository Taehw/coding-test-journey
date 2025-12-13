package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4562 { // 제출 시 클래스명은 Main

    public static void main(String[] args) throws IOException {

        // BufferedReader가 Scanner보다 메모리 효율과 속도 면에서 월등함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 예외 처리를 위해 throws IOException 필요

        for (int i = 0; i < n; i++) {
            // 한 줄에 여러 숫자가 들어올 때 공백 단위로 쪼개기
            StringTokenizer st = new StringTokenizer(br.readLine());

            // snake_case -> camelCase 적용
            int eatBrain = Integer.parseInt(st.nextToken());
            int needBrain = Integer.parseInt(st.nextToken());

            sb.append(eatBrain >= needBrain ? "MMM BRAINS\n" : "NO BRAINS\n");
        }

        System.out.print(sb);
    }
}