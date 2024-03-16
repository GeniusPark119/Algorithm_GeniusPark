import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
//        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 시
        int B = Integer.parseInt(st.nextToken()); // 분
        int C = Integer.parseInt(st.nextToken()); // 초

        int D = Integer.parseInt(br.readLine()); // 걸리는 시간 (초)

        // 1시간 = 60분 = 3600초

        int a = 0;
        int b = 0;
        int c = 0;

        a= D/3600;
        D %= 3600;
        b = D/60;
        D %= 60;
        c = D;

        C += c;

        if(C>=60){
            C -= 60;
            b ++;
        }

        B += b;
        if(B>=60){
            B-=60;
            a++;
        }

        A += a;

        if(A>=24)
            A %=24;

        System.out.println(A+" "+B+" "+C);

    }

}

