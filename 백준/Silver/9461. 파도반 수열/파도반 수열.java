import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dfs(num));
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static long dfs(int n){
        if(arr[n]!=0) return arr[n];

        arr[n] = dfs(n-3) + dfs(n-2);

        return arr[n];
    }

}


