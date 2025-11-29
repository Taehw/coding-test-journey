package silver.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.StringTokenizer;

public class boj_12891_doit {

    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); //문자열 크기
        int P = Integer.parseInt(st.nextToken()); //부분 문자열 크기
        int result = 0; //정답값

        checkArr = new int[4]; //비밀번호 체크 배열
        myArr = new int[4]; //비밀번호 체크 배열
        char[] A = new char[S]; //전체 문자열

        checkSecret = 0;
        //편하게 하기위해서, 4개중에 현재 몇개의 조건이 만족하는지
        //4개가 다 만족하면 4가되고 4가되면 result++;

        A = br.readLine().toCharArray(); //이건 st로 안받네???
        st = new StringTokenizer(br.readLine()); //????

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) { //체크배열 0이면 이미 만족한거라
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) { //부분 문자열 처음 받을때 세팅
            Add(A[i]);
        }

        if(checkSecret == 4) result++;

        //슬라이딩 윈도우 (j랑 i는 투포인터)
        for (int i = P; i < S; i++) {
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) result++;
        }

        System.out.println(result);
        br.close();
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) checkSecret++;
                //왜 >= 가 아닐까? -> checkSecret이 더 늘어나면 안됌
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) checkSecret++;
                break;
        }

    }
}
