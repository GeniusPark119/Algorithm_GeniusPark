import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N개의 줄
        int X = Integer.parseInt(st.nextToken()); // 예산
        int answer = 0;

        int max_five = (X - N * 1000) / 4000; // 5000원 쓸 수 있는 최대 횟수

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int five = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            if (one >= five) { // 무조건 1000원 지출
                answer += one;
                continue;
            }
            int gap = five - one;
            list.add(new int[]{five, one, gap}); // 5000원이 더 클때
        }
        Collections.sort(list, (o1, o2) -> o2[2] - o1[2]); // 만족도의 차이가 큰 순서대로 배치


        for (int i = 0; i < list.size(); i++) {
            if (max_five > 0) {
                max_five--;
                answer += list.get(i)[0];
            } else {
                answer += list.get(i)[1];
            }
        }

        System.out.print(answer);

        br.close();
    } // main
} // class