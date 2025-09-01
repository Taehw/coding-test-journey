package coding_basic_training.day4;

public class CommonMultiple {

    public static void main(String[] args) {

        int result = solution(60, 2, 3);
        System.out.println("result = " + result);
    }

    public static int solution(int number, int n, int m) {
        int answer = 0;

        if (number % n == 0 && number % m == 0) {
            answer = 1;
        }
        return answer;
    }
}
