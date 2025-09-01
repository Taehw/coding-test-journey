package coding_basic_training.day4;

public class ConditionalString {

    public static void main(String[] args) {

    }

    public static int solution(String ineq, String eq, int n, int m) {
        int answer = 0;

        if (ineq.equals(">") && eq.equals("=")) {
            boolean b = (n>=m);
            if (b) {
                answer = 1;
            }
        }

        if ((ineq.equals(">") && eq.equals("!"))) {
            boolean b = (n>m);
            if (b) {
                answer = 1;
            }
        }

        if ((ineq.equals("<") && eq.equals("="))) {
            boolean b = (n<=m);
            if (b) {
                answer = 1;
            }
        }

        if ((ineq.equals("<") && eq.equals("!"))) {
            boolean b = (n<m);
            if (b) {
                answer = 1;
            }
        }

        return answer;
    }
}
