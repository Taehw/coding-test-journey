package coding_basic_training.day4;

public class MultipleOfN {

    public static void main(String[] args) {

        int result = solution(98, 2);
        System.out.println("result = " + result);
    }

    public static int solution(int num, int n) {
        int answer = 0;

        if (num % n == 0) {
            answer = 1;
        }

        return answer;
    }
}
