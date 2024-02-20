//import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int cnt = (int) Math.round(n * 0.15);

        int ans = 0;

        for (int i = cnt; i < n - cnt; i++) {
            ans += arr[i];
        }


        System.out.println((int) Math.round((double) ans / (n - 2 * cnt)));


    }

}
