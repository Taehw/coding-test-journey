package silver.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2164_doit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            myQueue.add(i);
        }

        while (myQueue.size() > 1) {
            myQueue.poll();
            int temp = myQueue.poll();
            myQueue.add(temp);
        }

        System.out.println(myQueue.poll());
    }
}
