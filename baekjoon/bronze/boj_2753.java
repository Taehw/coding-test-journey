package bronze;

import java.io.*;

public class boj_2753 {

    //브5 - 윤년
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());

        System.out.println((year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 1 : 0);
    }
}
