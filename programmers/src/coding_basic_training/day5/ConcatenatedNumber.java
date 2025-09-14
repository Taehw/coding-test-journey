package coding_basic_training.day5;

import java.util.ArrayList;

public class ConcatenatedNumber {

    public static void main(String[] args) {
        // 테스트용 배열을 만듭니다.
        int[] testArray = {3, 4, 5, 2, 1};

        // 만든 배열을 인자로 넣어 solution 메소드를 호출합니다.
        int result = solution(testArray);

        // solution 메소드가 반환한 최종 결과를 출력해봅니다.
        System.out.println("최종 결과: " + result);
    }

    public static int solution(int[] num_list) {
        int answer = 0;

        /*
        * 1. 홀수리스트
        * 2. 짝수리스트
        *
        * 각 리스트 만들어서 조건문써서 넣으면 될듯
        * 이어붙일때 concat 쓰면 될듯?
        *
        * */

        //빈배열 만들고 싶은데
        //이럴때 ArrayList 를 사용하는건가?
        ArrayList<Integer> odd_list = new ArrayList<>();
        ArrayList<Integer> even_list = new ArrayList<>();

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                even_list.add(num_list[i]);
            } else {
                odd_list.add(num_list[i]);
            }
        }

        StringBuilder even_str = new StringBuilder();
        StringBuilder odd_str = new StringBuilder();

        for (int str : even_list) {
            even_str.append(str);
        }
        for (int str : odd_list) {
            odd_str.append(str);
        }


        answer = Integer.parseInt(even_str.toString()) + Integer.parseInt((odd_str.toString()));

        return answer;
    }
}
