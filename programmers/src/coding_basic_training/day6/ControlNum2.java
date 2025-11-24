package coding_basic_training.day6;

public class ControlNum2 {

    public static void main(String[] args) {

        int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
        String answer = solution(numLog);

        System.out.println(answer);
    }

    public static String solution(int[] numLog) {
        //numlog 배열의 현재값과 이전값을 비교
        //증가 or 감소한 값에 따라서 String result에 값을 하나씩 추가

        //for 문 - > outofIndex 안나게 i 값 생각 잘해주기
        //for문안에 if 계산된 결과값에 따라 String에 값을 추가?

        StringBuilder result = new StringBuilder();

        for (int i = 1; i < numLog.length; i++) {
            int value = numLog[i] - numLog[i-1];
            if (value == 1) {
                result.append("w");
            } else if (value == -1) {
                result.append("s");
            } else if (value == 10) {
                result.append("d");
            } else if (value == -10) {
                result.append("a");
            }
        }

        return result.toString();
     }
}
