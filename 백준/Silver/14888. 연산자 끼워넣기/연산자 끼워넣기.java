import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int max = -1_000_000_001, min = 1_000_000_001;
    static int[] arr, operators;

    static void select(int value, int idx) {
        if (idx == N) {
            if (value > max)
                max = value;
            if (value < min)
                min = value;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        select(value + arr[idx], idx + 1);
                        break;
                    case 1:
                        select(value - arr[idx], idx + 1);
                        break;
                    case 2:
                        select(value * arr[idx], idx + 1);
                        break;
                    case 3:
                        select(value / arr[idx], idx + 1);
                }
                operators[i]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N개의 수 2~11
        arr = new int[N];
        operators = new int[4]; // + - * /

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        select(arr[0], 1);


        System.out.println(max + "\n" + min);


    }


}