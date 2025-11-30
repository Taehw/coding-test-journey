package silver.stack;

import java.util.Scanner;
import java.util.Stack;

public class boj_1874 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        StringBuffer bf = new StringBuffer();

        boolean result = true;

        for (int i = 0; i < A.length; i++) {

            if (A[i] >= num) {
                while (A[i] >= num) {

                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int temp = stack.pop();
                if (temp > A[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }

        if(result) System.out.println(bf);

    }
}
