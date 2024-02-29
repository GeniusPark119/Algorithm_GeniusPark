import java.io.*;
import java.util.*;

public class Main {
    static Point[] arr;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new Point[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Point(start, end);
        }
        Arrays.sort(arr, (a, b) -> a.end == b.end ? a.start - b.start : a.end - b.end);

        int last = 0;
        int count = 0;

        for(int i=0;i<n;i++){
            if(last <= arr[i].start){
                count++;
                last = arr[i].end;
            }
        }

        System.out.println(count);
    }

    static class Point {
        int start;
        int end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}

