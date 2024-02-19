//import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int c = str.charAt(i) - 96;

            ans += c * (int)Math.pow(31,i) %1234567891;

        }

        System.out.println(ans);


    }

}
