package coding_basic_training.day3;

public class StringShuffler {

    public static void main(String[] args) {

        String result = Solution("aaaaa", "bbbbb");

        System.out.println("result = " + result);
    }

    public static String Solution(String str1, String str2) {

        String answer = "";

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();


        for (int i = 0; i < str1.length(); i++) {

            answer = answer + chars1[i] + chars2[i];
        }

        return answer;
    }
}
