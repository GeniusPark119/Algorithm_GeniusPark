import java.io.*;
import java.util.*;

//이중분할?
public class Main {

    static int[] arr;
    static int m;
    static int mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        int max = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        twosplit(0, max);

        System.out.println(mid-1);// m이상이 되기 바로 진전의 위를 구하고 1를 뺀다.

    }

    public static void twosplit(int start, int end) { // m이상이 되기 바로 진전의 위를 구하고 1를 뺀다.

        if (start >= end) {
            mid = end;
            return;
        }

        mid = (start + end) / 2;

        long sum = 0;

        for (int x : arr) {
            if (x - mid > 0)
                sum += (x - mid);
        }
        if (sum >= m) {
            twosplit(mid+1, end);

        } else {
            twosplit(start, mid);
        }

    }

}


