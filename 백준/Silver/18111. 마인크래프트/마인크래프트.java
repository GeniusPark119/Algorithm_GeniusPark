//import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer,Integer> map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());

        int[][] board = new int[n][m];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st1.nextToken());
                max = Math.max(max,board[i][j]);
                min = Math.min(min,board[i][j]);
            }
        }

        int time = Integer.MAX_VALUE;
        int floor = 0;

        for(int i=min;i<=max;i++){
            int in = 0;
            int out = b;
            int tmpTime = 0;
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(i<board[j][k]){
                        out += board[j][k]-i;
                        tmpTime += 2*(board[j][k]-i);
                    }else if(i>board[j][k]){
                        in += i-board[j][k];
                        tmpTime += i-board[j][k];
                    }
                }
            }
//            System.out.println(in);
//            System.out.println(out);
            if(in>out)
                continue;
            time = Math.min(time,tmpTime);
            if(time>=tmpTime){
                time = tmpTime;
                floor = i;
            }
        }

        System.out.println(time+" "+floor);



    }

}
