import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동굴 길이
        int H = Integer.parseInt(st.nextToken()); // 동굴 높이

        int[] bottom = new int[H + 1]; // 높이가 idx에서 파괴되는 석순의 수 ( 밑에서 올라옴 )
        int[] top = new int[H + 1]; // 높이가 idx에서 파괴되는 종유석의 순 ( 위에서 내려감 )

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                ++bottom[Integer.parseInt(br.readLine())]; // 석순
            } else {
                ++top[Integer.parseInt(br.readLine())]; // 종유석
            }
        }
        // 높이가 i+1에서 파괴되는 장애물은 i에서도 파괴된다.
        for (int i = H - 2; 0 < i; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }

        int min = N + 1; // 파괴되는 장애물 개수의 최소값
        int cnt = 0; // 최소값의 경우의 수가 몇개있는지

        for (int i = 1; i <= H; i++) {
            int cntBlock = bottom[i] + top[H - i + 1]; // 왜 +1를 하는거지?
            if (cntBlock < min) { // 장애물 최소값이 바뀌면
                min = cntBlock;
                cnt = 1; // 1부터 세줘야한다.
            } else if (cntBlock == min)
                cnt++; // 만약 최소값이랑 같으면 +1
        }


        System.out.print(min + " " + cnt);
        br.close();


    } // main


} // class