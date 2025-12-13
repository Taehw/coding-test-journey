package bronze.sorting;

import java.util.Scanner;

public class boj_1427_doit {

    //선택정렬로 풀기
    //Arrays.sort도 가능
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] array = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            array[i] = Integer.parseInt(str.substring(i, i+1)); //??? subString 까먹음 ㅠㅠ
        }

        //선택정렬 알고리즘 구현
        for (int i = 0; i < str.length(); i++) {
            int maxIndex = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }

            if (array[i] < array[maxIndex]) { //내림차순
                int temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }

        for (int i : array) {
            System.out.print(i);
        }
    }
}
