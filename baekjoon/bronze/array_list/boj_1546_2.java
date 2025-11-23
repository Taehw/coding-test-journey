package bronze.array_list;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1546_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //N 입력받기
        int num = sc.nextInt();
        //scores 배열 선언
        double[] scores = new double[num];
        double[] fake_scores = new double[num];

        //점수 입력
        for (int i = 0; i < num; i++) {
            scores[i] = sc.nextInt();
        }

        //최댓값 구하기
        Arrays.sort(scores);
        double max = scores[scores.length-1];

        //fake_scores에 변환된 점수 입력받기 -> for문 i < N
        for (int i = 0; i < num; i++) {
            fake_scores[i] = scores[i] / max * 100;
        }

        //평균구하기
        double avg, sum = 0;
        for (double fakeScore : fake_scores) {
            sum += fakeScore;
        }
        avg = sum / num;

        System.out.println(avg);
    }
}
