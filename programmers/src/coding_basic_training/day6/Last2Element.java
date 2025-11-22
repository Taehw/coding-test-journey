package coding_basic_training.day6;

import java.util.Arrays;

public class Last2Element {

    public static void main(String[] args) {
        int[] num_list = {2, 1, 6, 5};

        int[] result = solution(num_list);
        System.out.println(Arrays.toString(result));
    }

    public static  int[] solution(int[] num_list) {
        int[] answer = {};
        int addNum;
        int end = num_list.length - 1;

        answer = new int[num_list.length + 1];

        if (num_list[end] > num_list[end-1]) {
            addNum = num_list[end] - num_list[end-1];
        } else {
            addNum = num_list[end] * 2;
        }

        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
        answer[end+1] = addNum;

        return answer;
    }

}
