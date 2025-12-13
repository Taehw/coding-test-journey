package bronze;

import java.util.Scanner;

public class boj_13866 {

    //브론즈4 - 팀나누기
    //스킬레벨은 10000이하 오름차순으로 주어짐
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[4];

        for (int i = 0; i < 4; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println(Math.abs(scores[3] + scores[0] - scores[2] - scores[1]));

        //1, 2, 3, 4번 선수가 있다고할때
        //1, 2 vs 3, 4 는 절대 최소가 될수 없음
        //1, 3 - 2, 4
        //1, 4 - 2, 3
        //위의 두개의 조합중 하나 ㅇㅎㅇㅎ
        //아마 내가 틀린이유는 값이 - 가 나왔기 때문인듯 ㅇㅎ


    }
}
