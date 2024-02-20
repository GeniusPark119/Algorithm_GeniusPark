//import java.util.Scanner;

import java.io.*;
import java.util.*;

public class Main {
    static int[] number;

    public static void main(String[] args) throws Exception {

        number = new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int channel = Integer.parseInt(br.readLine()); // 채널 int
        int m = Integer.parseInt(br.readLine());
        if (m > 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                number[Integer.parseInt(st.nextToken())] = 1;
            }
        }


        int ans = Math.abs(channel - 100);

        loop:
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);

            for (int j = 0; j < str.length(); j++) {
                if (number[str.charAt(j) - '0'] == 1)
                    continue loop;
            }

            ans = Math.min(ans, Math.abs(channel - i) + str.length());
        }

        System.out.println(ans);


    }
}
