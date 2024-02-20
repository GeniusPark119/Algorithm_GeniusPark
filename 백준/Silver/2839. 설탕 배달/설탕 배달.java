//import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Integer> map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        int ans = 0;

        if (n == 4 || n == 7)
            ans = -1;
        else if (n % 5 == 0)
            ans = n / 5;
        else if (n % 5 == 1 || n % 5 == 3)
            ans = n / 5 + 1;
        else if (n % 5 == 2 || n % 5 == 4)
            ans = n / 5 + 2;

        System.out.println(ans);


    }

}
