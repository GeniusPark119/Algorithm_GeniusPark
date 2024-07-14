import java.io.*;
import java.util.*;

public class Main { // 1057

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int count = 0;

        while(J != H){

            J = J / 2 + J % 2;
            H = H / 2 + H % 2;

            count++;
        }

        System.out.print(count);

        br.close();

    }

}