package coding_basic_training.day5;

public class ProcessCode {

    public static void main(String[] args) {

        String result = solution("");
        System.out.println("result = " + result);
    }

    public static String solution(String code) {
        String answer = "";

        //변수 : ret(String), mode(String), idx(int, 0~ code.length - 1)
        //code[idx] == mode ("0" or "1")
        /*
        * 문제 조건
        * - 시작할때 모드는 0
        * - return 하려는 ret이 빈문자열이라면 "Empty"를 return
        *
        *
        *
        *
        * */

        StringBuilder ret = new StringBuilder();
        String mode = "0";

        char[] ch_code = code.toCharArray();

        for (int idx = 0; idx < code.length(); idx++) {

//            System.out.println("ch_code = " + ch_code[idx]);

            if (mode.equals("0") && ch_code[idx] == '1') {
//                System.out.println("hello");
                mode = "1";
            } else if (mode.equals("0") && ch_code[idx] != '1') {
                if (idx % 2 == 0) {
                    ret.append(ch_code[idx]);
                }
            } else if (mode.equals("1") && ch_code[idx] == '1') {
                mode = "0";
            } else if (mode.equals("1") && ch_code[idx] != '1') {
                if (idx % 2 == 1) {
                    ret.append(ch_code[idx]);
                }
            }

//            System.out.println("mode = " + mode);

        }

        if (ret.isEmpty()) {
            answer = "EMPTY";
        } else {
            answer = ret.toString();
        }

        return answer;
    }

}
