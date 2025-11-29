package bronze;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] correctPieces = {1, 1, 2, 2, 2, 8}; //정답 피스

        StringBuilder sb = new StringBuilder();

        //현재 피스
        for (int i = 0; i < 6; i++) {
            int inputPiece = Integer.parseInt(st.nextToken());

            int result = correctPieces[i] - inputPiece;

            sb.append(result).append(" ");
        }

        System.out.println(sb);

    }
}
