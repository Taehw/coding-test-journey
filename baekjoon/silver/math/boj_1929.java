package silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstNum = Integer.parseInt(st.nextToken());
        int secondNum = Integer.parseInt(st.nextToken());
        int size = secondNum - firstNum + 1;

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = firstNum;
            firstNum++;
        }
        //수의 범위만큼 배열만들기

        //에라스토테네스의 체 시작(이중for문)
        for (int i = 2; i < size; i++) { //나눠주는 수는 2부터 시작

            for (int j = 0; j < size; j++) { //선택되지않은 수의 다음수부터(i+1)

                if (numbers[j] == 1) { //처음이 1일경우 1은 소수가 아니므로 삭제
                    numbers[j] = 0; //삭제 처리 = 0
                    continue;
                }

                if (numbers[j] != 0) {
                    if ( i != numbers[j] &&  numbers[j] % i == 0) { //이미 삭제된 수가 아니고 선택된 수의 배수라면 삭제처리
                        numbers[j] = 0;
                    }
                }
            }

        }

        for (int number : numbers) {
            if (number != 0) {
                System.out.println(number);
            }
        }
    }
}
