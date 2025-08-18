package coding_basic_training.day1;

import java.util.Scanner;

public class SwapCase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        char[] alp = a.toCharArray();

        for (int i = 0; i < alp.length; i++) {
            if (Character.isUpperCase(alp[i])) {
                alp[i] = Character.toLowerCase(alp[i]);
            } else {
                alp[i] = Character.toUpperCase(alp[i]);
            }
        }

        System.out.println(alp);
    }
}
