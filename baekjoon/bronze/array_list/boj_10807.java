package bronze.array_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10807 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정수의 개수 N 100가지 정수 주어지면 한번에 입력받아야될게 많아지니까
        //BufferedReader랑 StringTokenizer 깔고 감  그치?

        int num = Integer.parseInt(st.nextToken()); //여기서 굳이 st 사용안해도됨 걍 br.readLine() 만 해도 문제 x

        //줄바뀌니까 초기화?
        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[num];


        for (int i = 0; i < num; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int number : numbers) {
            if (number == v) {
                count++;
            }
        }

        System.out.println(count);
    }
}
