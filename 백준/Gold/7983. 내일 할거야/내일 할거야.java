import java.io.*;
import java.util.*;

public class Main { // 7983 내일 할거야

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] homework = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            homework[i][0] = Integer.parseInt(st.nextToken());
            homework[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(homework, (o1, o2) -> o2[1] - o1[1]);

        int day = 1000000001;

        for(int i=0;i<n;i++){
            int d = homework[i][0];
            int t = homework[i][1];

            while(d-->0){
                if(day<=t){
                    day--;
                    t--;
                }else{
                    day = t-1;
                    t--;
                }
            }
        }

        System.out.print(day);


    }

}