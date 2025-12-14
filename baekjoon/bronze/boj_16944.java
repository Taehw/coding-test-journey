package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16944 {

    //이제좀 풀만한 문제가 나왔네 -> 브2 ㅋㅋ 강력한 비밀번호
    public static void main(String[] args) throws IOException {
        final String SPECIAL_CHARS = "!@#$%^&*()-+";

        // S의 뒤에 추가해야 하는 글자의 최소 개수
        // 규칙배열? 숫자 + 알파벳 소문자 + 알파벳 대문자 + 특수문자(!@#$%^&*()-+)
        // 6글자 이상
        // 규칙은 지켰어도 4글자인경우 -> 2글자
        // 문자열 -> 순회하면서 각 문자가 조건에 맞는지 검사
        // 숫자면 -> 0번째 인덱스 ++
        // 특수문자면 -> 1번째 인덱스 ++
        // 알파벳 대문자면 -> 2번째 인덱스 ++
        // 알파벳 소문자면 -> 3번째 인덱스 ++
        // if 문자열의 길이가 >= 6 -> 인덱스의 값이 0인것만 result에
        // if 문자열으 길이가 < 6 -> 인덱스의 값이 0인것부터 채워서 result에 넣고 부족한 문자열 길이 - result 를 뺏는데 더 채워야되면 +1하고
        // 너무 하드코딩인가

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int strlen = Integer.parseInt(br.readLine());
        String pw = br.readLine();
        char[] chars = pw.toCharArray();

        int[] valPw = new int[4];

        for (int i = 0; i < strlen; i++) {
            if (chars[i] == '!' || chars[i] == '@' || chars[i] == '#' || chars[i] == '$' || chars[i] == '%' || chars[i] == '^' || chars[i] == '&' || chars[i] == '*' || chars[i] == '(' || chars[i] == ')' || chars[i] == '-' || chars[i] == '+') { //특수문자
                valPw[0]++;
            } else if (chars[i] >= 65 && chars[i] <= 90) { //대문자
                valPw[1]++;
            } else if (chars[i] >= 97 && chars[i] <= 122) { //소문자
                valPw[2]++;
            } else { //숫자인경우
                valPw[3]++;
            }
        }

        //부족한 문자열 처리
        int result = 0;

        for (int i : valPw) {
            if (i == 0) {
                result++;
            }
        }

        if (result + pw.length() < 6) {
            result += 6 - result+pw.length();
        }

        System.out.println(result);
    }
}
