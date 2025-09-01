package coding_basic_training.day4;

public class ReturnByEvenOrOdd {

    public static void main(String[] args) {

        int result = solution(10);
        System.out.println("result = " + result);
    }

    public static int solution(int n) {
        int answer = 0;

        if (n % 2 == 0) {
            for (int i = 0; i <= n; i = i + 2) {
                answer += i*i;
            }
        } else {
            for (int i = 1; i <= n; i = i + 2) {
                answer += i;
            }
        }

        return answer;
    }
}
