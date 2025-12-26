package silver;

import java.util.*;
import java.io.*;

public class boj_11558 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalTestNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < totalTestNum; i++) {

            int totalPlayerNum = Integer.parseInt(br.readLine()); //테스트케이스마다 정해지는 player숫자
            int[] deathNum = new int[totalPlayerNum + 1]; //Index를 1부터 시작하기

            for (int j = 1; j <= totalPlayerNum; j++) {
                deathNum[j] = Integer.parseInt(br.readLine()); //각 플레이어가 지목한 숫자 입력
            }


            //최소숫자를 찾는 로직

            int nextIndex = 1;
            int count = 0; //이동할때마다 ++, 정답 변수

            while (deathNum[nextIndex] != totalPlayerNum && count < totalPlayerNum) {

                nextIndex = deathNum[nextIndex];
                count++;

            }

            if (deathNum[nextIndex] == totalPlayerNum) {
                System.out.println(count + 1); // 마지막 주경이에게 가는 횟수 1 더해서 출력
            } else {
                System.out.println(0);
            }
        }
    }
}