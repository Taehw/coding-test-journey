package coding_basic_training.day3;

public class NumberComparator {

    public static void main(String[] args) {

        int result = solution(2, 91);
        System.out.println("result = " + result);

    }

    public static int solution(int a, int b) {

        int answer = 0;

        String sa = String.valueOf(a);
        String sb = String.valueOf(b);

        int mul = 2 * a * b;
        int sab = Integer.parseInt(sa + sb);

        if (mul > sab) {
            answer = mul;
        } else {
            answer = sab;
        }

        return answer;
    }
}
