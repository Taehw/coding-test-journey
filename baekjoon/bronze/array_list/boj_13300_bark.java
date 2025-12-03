package bronze.array_list;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj_13300_bark {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. N(학생 수), K(방 최대 인원) 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2. 성별/학년별 학생 수를 저장할 2차원 배열 선언
        // 행(Row): 0(여학생), 1(남학생) -> 크기 2
        // 열(Col): 1~6학년 (인덱스 편의를 위해 크기 7로 선언하고 0번은 비워둠)
        int[][] students = new int[2][7];

        // 3. 학생 정보 입력 및 카운팅
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken()); // 0 or 1
            int grade = Integer.parseInt(st.nextToken());  // 1 ~ 6

            students[gender][grade]++;
        }

        int roomCount = 0;

        // 4. 필요한 방의 개수 계산
        // 성별(0~1)과 학년(1~6)을 모두 순회
        for(int s = 0; s < 2; s++) {
            for(int g = 1; g <= 6; g++) {
                int count = students[s][g];
                if(count == 0) continue; // 학생이 없으면 방 필요 없음

                // [최적화 팁] 올림 나눗셈 공식: (A + B - 1) / B
                // if (count % K != 0) room++ 과 같은 로직이지만 수식으로 한 번에 처리
                roomCount += (count + K - 1) / K;
            }
        }

        System.out.println(roomCount);
    }
}