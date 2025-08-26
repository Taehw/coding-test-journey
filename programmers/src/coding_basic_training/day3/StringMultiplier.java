package coding_basic_training.day3;

public class StringMultiplier {

    public static void main(String[] args) {

        String result = solution("love", 10);

        System.out.println("result = " + result);
    }

    public static String solution(String my_string, int k) {
        String answer = "";

        answer = my_string;

        for (int i = 1; i < k; i++) {
            answer = answer.concat(my_string);
        }

        return answer;
    }
}
