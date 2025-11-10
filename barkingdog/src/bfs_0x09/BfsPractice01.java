package bfs_0x09;

import java.util.LinkedList;
import java.util.Queue;

public class BfsPractice01 {

    //1. static nested class (혹은 Point, Pos, Node)
    //C++의 pair<int, int> 역할
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        //2. Queue 인터페이스, LinkedList 구현체
        //C++의 queue<pair<int, int>> Q; 와 같음
        Queue<Point> q = new LinkedList<>();

        //3. 큐에 원소 추가 (Enqueue)
        //C++의 Q.push({0,0})과 같음
        q.add(new Point(0, 0));

        //4. 큐에서 원소 제거 (Dequeue)
        //C++의 Cur = Q.front(); Q.pop(); 과 같음
        Point current = q.poll();

        //5. 큐가 비었는지 확인
        //C++의 Q.empty() 와 같습니다.
        if (q.isEmpty()) {
            //...
        }

        //6. 원소 접근
        //C++ 의 cur.X, cur.Y (매크로 사용시)
        //혹은 cur.first, cur.second
        int currentX = current.x;
        int currentY = current.y;
    }
}
