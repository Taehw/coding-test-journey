package coding_basic_training.day2;

import java.util.Arrays;

public class OverwriteString {

    public static void main(String[] args) {

        String answer = solution("He11oWor1d", "lloWorl", 2);

        System.out.println(answer);

    }

    public static String solution(String my_string, String overwrite_string, int s) {

        String answer = "";

        char[] chars = my_string.toCharArray();
        char[] overchars = overwrite_string.toCharArray();

        for (int i = s; (i - s)  < overwrite_string.length() ; i++) {

            chars[i] = overchars[i - s];

        }

        answer = String.valueOf(chars);

        return answer;
    }
}
