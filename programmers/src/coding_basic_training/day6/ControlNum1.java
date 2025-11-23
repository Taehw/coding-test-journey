package coding_basic_training.day6;

public class ControlNum1 {

    public static void main(String[] args) {

        int result = Solution(0, "wsdawsdassw");
        System.out.println(result);
    }

    public static int Solution(int n, String control) {

        char[] control_char = control.toCharArray();

        for (int i = 0; i < control_char.length; i++) {
            if (control_char[i] == 'w') {
                n += 1;
            } else if (control_char[i] == 's') {
                n -= 1;
            } else if (control_char[i] == 'd') {
                n += 10;
            } else {
                n -= 10;
            }
        }

        return n;
    }
}
