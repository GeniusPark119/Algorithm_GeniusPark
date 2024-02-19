//import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Main {

//    static Stack<Integer> stack;

    static List<Point> list;

    public static void main(String[] args) throws Exception {
//        stack = new Stack<>();
        list = new ArrayList<>();

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Point(x,y));
        }

        Collections.sort(list,(a,b)-> a.y!=b.y? a.y-b.y :
                a.x-b.x);

        for(Point p : list){

            System.out.println(p.x +" "+p.y);
        }



    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
