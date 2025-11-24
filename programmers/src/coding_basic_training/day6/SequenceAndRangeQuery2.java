package coding_basic_training.day6;

import java.util.Arrays;

public class SequenceAndRangeQuery2 {

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 2},{0, 3, 2},{0, 2, 2}};

        int[] result = solution(arr, queries);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};

        for (int i = 0; i < queries.length; i++) {

            for (int j = queries[i][0]; j <= queries[i][1]; j++) {

                int min = arr[queries[i][0]];
                if (min > arr[j]) {
                    min = arr[j];
                }
            }
        }

        return answer;
    }
}
