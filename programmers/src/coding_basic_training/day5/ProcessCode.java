package coding_basic_training.day5;

public class ProcessCode {

    public static void main(String[] args) {

        String result = solution("");
        System.out.println("result = " + result);
    }

    public static String solution(String code) {

        StringBuilder answer = new StringBuilder();

        int mode = 0;

        char[] chars = code.toCharArray();

        for (int idx = 0; idx < code.length(); idx++) {
            if (mode == 0) {
                if (chars[idx] == '1') {
                    mode = 1;
                } else {
                    if (idx % 2 == 0) {
                        answer.append(chars[idx]);
                    }
                }
            } else {
                if (chars[idx] == '1') {
                    mode = 0;
                } else {
                    if (idx % 2 == 1) {
                        answer.append(chars[idx]);
                    }
                }
            }
        }

        if (answer.toString().equals("")) {
            answer = new StringBuilder("Empty");
        }
        return answer.toString();
    }

}
