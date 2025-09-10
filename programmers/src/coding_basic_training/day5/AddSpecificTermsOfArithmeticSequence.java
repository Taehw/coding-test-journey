package coding_basic_training.day5;

//등차수열의 특정한 항만 더하기
public class AddSpecificTermsOfArithmeticSequence {

    public static void main(String[] args) {

    }

    public static int solution(int a, int d, boolean[] included) {

        int answer = 0;

        //등차수열 공식 -> a+dn, n을 그냥 i라고 생각하면 됨
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                answer += a + i*d;
            }
        }

        return answer;
    }
}
