//import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        int[][] arr = new int[41][2]; // 0과 1의 개수

        for(int i=0;i<41;i++){
            arr[i][0] = -1;
        }

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        for(int i=0;i<n;i++){
            int num  = Integer.parseInt(br.readLine());

            for(int j=2;j<=num;j++){
                if(arr[j][0]==-1){
                    arr[j][0] = arr[j-1][0] + arr[j-2][0];
                    arr[j][1] = arr[j-1][1] + arr[j-2][1];
                }
            }
            System.out.println(arr[num][0]+" "+arr[num][1]);
        }
    }
}
