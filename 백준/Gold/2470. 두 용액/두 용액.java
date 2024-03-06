import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        int x = 0;
        int y = 0;
        int min = Integer.MAX_VALUE;


        while (start < end) {
            int tmp_sum = arr[start] + arr[end];

            if (Math.abs(tmp_sum) < min) {
                min = Math.abs(tmp_sum);
                x = arr[start];
                y = arr[end];

                if (tmp_sum == 0)
                    break;
            }
            if (tmp_sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        sb.append(x + " ");
        sb.append(y);


        System.out.println(sb);


    }

    static class Pointers {
        int x;
        int y;
        int sum;

        Pointers(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
}


