package coding_basic_training.day2;

import java.util.Scanner;

public class ConcatenateStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        System.out.println(a.concat(b));
    }
}
