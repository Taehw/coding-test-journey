package coding_basic_training.day4;

public class ReturnByFlag {

    public static void main(String[] args) {

        int result1 = solution(-4, 7, true);
        int result2 = solution(-4, 7, false);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

    public static int solution(int a, int b, boolean flag) {
        int answer = 0 ;

        if (flag) {
            answer = a + b;
        } else {
            answer = a - b;
        }

        return answer;
    }
}
