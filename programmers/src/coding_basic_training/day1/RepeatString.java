package coding_basic_training.day1;

import java.util.Scanner;

public class RepeatString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

//        System.out.println(str.repeat(n)); 다른사람의 풀이 이런것도 있구나

        for (int i = 0; i < n; i++) {
            System.out.print(str);
        }
    }
}
