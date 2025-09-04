package coding_basic_training.day5;

public class ProductAndSumOfElements {

    public static void main(String[] args) {


        int[] num_list = {5,7,8,3};

        int result = solution(num_list);
        System.out.println("result = " + result);
    }

    public static int solution(int[] num_list) {

        int answer = 0;

        int product = 1;
        int sum = 0;

        for (int i : num_list) {
            product *= i;
            sum += i;
        }

        if (product < (sum * sum)) {
            answer = 1;
        }

        return answer;
    }

}
