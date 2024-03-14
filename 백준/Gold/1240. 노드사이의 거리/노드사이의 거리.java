import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static boolean[] visited;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];

        for(int i=0;i<n-1;i++){

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            board[a][b] = dis;
            board[b][a] = dis;

        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(getDis(a,b));
        }
    }

    static int getDis(int a,int b){
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[n+1];

        queue.offer(new Point(a,0));
        visited[a] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            int node = p.node;
            int dep = p.dep;

            if(node==b) return dep;

            for(int i=1;i<=n;i++){
                if(board[node][i]!=0 && !visited[i]){
                    queue.offer(new Point(i,dep+board[node][i]));
                    visited[i] = true;

                }
            }

        }
        return 0;
    }

    static class Point{
        int node;
        int dep;

        Point(int node,int dep){
            this.node = node;
            this.dep = dep;
        }

    }

}

