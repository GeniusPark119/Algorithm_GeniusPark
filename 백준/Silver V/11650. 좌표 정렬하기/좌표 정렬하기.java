import java.util.Scanner;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;


//나이순 정렬

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) {

        sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Point[] arr = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[i] = new Point(x,y);

        }

        Arrays.sort(arr,(a,b)-> a.x!=b.x? a.x - b.x : a.y - b.y);

        for(Point p : arr){
            sb.append(p.x);
            sb.append(" ");
            sb.append(p.y);
            sb.append("\n");
        }


        System.out.println(sb.toString());

    }

    static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
