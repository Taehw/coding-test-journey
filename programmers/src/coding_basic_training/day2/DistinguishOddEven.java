package coding_basic_training.day2;

import java.util.Scanner;

public class DistinguishOddEven {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println(n + " is even");
        } else {
            System.out.println(n + " is odd");

        }
    }
}
