package bronze.array_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13300 {

    //학생 클래스를 만들어서 할수도 있겠다
    //하지만 좀더 간단한 방법이 없을까
    //학생수는 1000명까지
    //한방 최대 인수는 1000명


    //학년, 성별로 나눈다음 최대갯수로 나누기?

    //총 12개의 그룹으로 나누고
    //s랑 Y 가 1, 1 -> 0 번째 그룸 ++ -> 최대개수로 나누고 몫을 카운트에 더해주고 나머지가 0이 아니면 count ++ 하나 더해주기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] roomValue = new int[12];


        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            int sex  = Integer.parseInt(st.nextToken());
            int years = Integer.parseInt(st.nextToken());

            if (sex == 1 && years == 1) {
                roomValue[0] ++;
            } else if (sex == 0 && years == 1) {
                roomValue[1] ++;
            } else if (sex == 1 && years == 2) {
                roomValue[2] ++;
            }else if (sex == 0 && years == 2) {
                roomValue[3] ++;
            }else if (sex == 1 && years == 3) {
                roomValue[4] ++;
            }else if (sex == 0 && years == 3) {
                roomValue[5] ++;
            }else if (sex == 1&& years == 4) {
                roomValue[6] ++;
            }else if (sex == 0 && years == 4) {
                roomValue[7] ++;
            }else if (sex == 1 && years == 5) {
                roomValue[8] ++;
            }else if (sex ==0 && years == 5) {
                roomValue[9] ++;
            }else if (sex == 1 && years == 6) {
                roomValue[10] ++;
            }else if (sex == 0 && years == 6) {
                roomValue[11] ++;
            }


        }

        int count = 0;

        for (int value : roomValue) {
            count += value / k;
            if (value % k > 0) {
                count++;
            }
        }

        System.out.println(count);

    }

}
