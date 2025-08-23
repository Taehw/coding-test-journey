package coding_basic_training.day3;

public class CharListToStringConverter {

    public static void main(String[] args) {

        String[] arr = {"a", "b", "c"};

        String result = Solution(arr);

        System.out.println("result = " + result);
    }

    public static String Solution(String[] arr) {

        String answer = "";

        for (String string : arr) {
            answer = answer.concat(string);
        }

        return answer;
    }
}
