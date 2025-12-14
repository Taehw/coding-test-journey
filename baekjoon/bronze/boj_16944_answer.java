package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16944_answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int N = Integer.parseInt(br.readLine()); // 현재 비밀번호 길이
        String password = br.readLine();         // 비밀번호 문자열

        // 2. 포함 여부를 확인할 플래그 변수
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        // 특수문자 목록 문자열
        String specialChars = "!@#$%^&*()-+";

        // 3. 문자열을 순회하며 각 조건 검사
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (specialChars.indexOf(ch) >= 0) {
                // 해당 문자가 특수문자 문자열에 포함되어 있다면 특수문자로 인정
                hasSpecial = true;
            }
        }

        // 4. 부족한 종류의 개수 계산
        int missingTypeCount = 0;
        if (!hasDigit) missingTypeCount++;
        if (!hasLower) missingTypeCount++;
        if (!hasUpper) missingTypeCount++;
        if (!hasSpecial) missingTypeCount++;

        // 5. 길이 조건 (최소 6글자)을 위해 필요한 문자 수 계산
        // N이 6 이상이면 0, 6 미만이면 (6 - N)
        int missingLength = 6 - N;
        if (missingLength < 0) missingLength = 0;

        // 6. 정답 출력
        // 부족한 종류를 채우면 그만큼 길이도 늘어납니다.
        // 따라서 둘 중 더 큰 값이 최소 추가 횟수입니다.
        System.out.println(Math.max(missingTypeCount, missingLength));
    }
}