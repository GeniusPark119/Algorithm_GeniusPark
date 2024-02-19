//import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long ans = 0;
        long pow = 1;

        for (int i = 0; i < n; i++) {

            ans += (str.charAt(i) - 96)*pow;

            pow = (pow*31)%1234567891;


        }

        System.out.println(ans%1234567891);


    }

}
