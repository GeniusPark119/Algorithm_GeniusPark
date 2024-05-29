import java.io.*;
import java.util.*;

public class Main { // 7983 내일 할거야

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] homework = new int[n][2]; // n개의 과제의 { 걸리는 일 d, 기한 t } 저장

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            homework[i][0] = Integer.parseInt(st.nextToken());
            homework[i][1] = Integer.parseInt(st.nextToken());
        }
        // greedy : 기한이 가장 긴 과제부터 터는것이 가장 최적
        Arrays.sort(homework, (o1, o2) -> o2[1] - o1[1]);

        int day = 1000000001; // 최댓값

        for (int i = 0; i < n; i++) {
            int d = homework[i][0];
            int t = homework[i][1];

            while (d-- > 0) { // 걸리는 일을 털자!
                if (day <= t) { // 만약 날짜가 t와 같거나 작으면
                    day--; // 날짜도 깎고
                    t--; // 기한도 깎고
                } else { // 만약 날짜가 더 뒤에 있으면 가져와야함
                    day = t - 1; // 가져와서 깎기
                    t--; // 기한도 깎고
                }
            }
        }

        System.out.print(day);


    }

}