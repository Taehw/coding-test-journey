package silver.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2164 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        //N을 입력
        //for(N만큼) -> q에 카드값 저장
        //for(q에 1장 남을때까지) 1. poll해서 버리고 2. 두번째 poll은 offer
        //poll 할때마다 count--;

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (N > 1) {
            q.poll(); N--;
            q.add(q.poll());
        }

        System.out.println(q.poll());
    }
}
