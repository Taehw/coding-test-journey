package coding_basic_training.day2;

import java.util.Scanner;

public class RotateString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        char[] charAraay = a.toCharArray();

        for (char c : charAraay) {
            System.out.println(c);
        }
    }
}
