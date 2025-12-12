package bronze;

import java.io.*;
import java.util.StringTokenizer;


public class boj_30214 {

    public static void main(String[] args) throws IOException {
        //브5 - An Easy-Peasy Problem
        //문제가 영어임 -> 아니 안읽혀 썅

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        System.out.println(first >= (second + 1) / 2 ? "E" : "H");
    }
}
