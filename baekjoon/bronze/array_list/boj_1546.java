package bronze.array_list;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //과목 개수
        int N = sc.nextInt();


        int[] scores = new int[N]; //과목 개수 만큼의 배열 생성
        //점수입력
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        //최댓값 구하기
        int M = scores[0];
        for (int i = 0; i < N; i++) {
            if (scores[i] > M) {
                M = scores[i];
            }
        }

//        System.out.println(M);

        double sum = 0;
        for (int score : scores) {
            sum += ((double) score / M) * 100;
//            System.out.println(sum);
        }

        double average = (double) sum / N; //왜 캐스팅?

        System.out.println(average);
    }
}
