package coding_basic_training.day3;

public class LargerMerger {

    public static void main(String[] args) {

        int result = solution(89, 8);
        System.out.println("result = " + result);

    }

    public static int solution(int a, int b) {

        int answer = 0;

        String sa = String.valueOf(a);
        String sb = String.valueOf(b);

        int sab = Integer.parseInt(sa + sb);
        int sba = Integer.parseInt(sb + sa);

        if (sab >= sba) {
            answer = sab;
        } else {
            answer = sba;
        }

        return answer;
    }
}
