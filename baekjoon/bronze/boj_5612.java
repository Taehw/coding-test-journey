package bronze;

import java.io.*;
import java.util.*;

public class boj_5612 {

    public static void main(String[] args) throws IOException {

        //브3 - 터널의 입구와 출구
        /*
        3
        2
        2 3
        2 3
        4 1

        최대 -> 들어오는 모든차 - 나가는차
        결과값을 묻는게 아니라 실시간으로 터널안에 차량의 최대갯수를 뽑아내는 문제
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int time = Integer.parseInt(br.readLine());
        int carNum = Integer.parseInt(br.readLine());

        int[] findMax = new int[time + 1];
        findMax[0] = carNum;

        for (int i = 0; i < time; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int entrance = Integer.parseInt(st.nextToken());
            int exit = Integer.parseInt(st.nextToken());

            carNum = carNum + entrance - exit;

            //터널안의 차량이 0보다 적어지는 경우
            if (carNum < 0) {
                System.out.println(0);
                break;
            }

            //1분동안의 차량의 최대개수를 저장
            findMax[i+1] = carNum;
        }

        if (carNum >= 0) {
            int max = findMax[0];
            for (int i : findMax) {
                if (max < i) {
                    max = i;
                }
            }
            System.out.println(max);
        }

    }
}
