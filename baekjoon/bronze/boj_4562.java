package bronze;

import java.util.Scanner;

public class boj_4562 {

    public static void main(String[] args) {

        //브4 - No Brainer (English)

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int eat_brain = sc.nextInt();
            int need_brain = sc.nextInt();
            sb.append(eat_brain >= need_brain ? "MMM BRAINS\n" : "NO BRAINS\n");
        }

        System.out.println(sb);
    }
}
