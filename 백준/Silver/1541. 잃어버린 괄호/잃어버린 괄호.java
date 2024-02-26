import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());


        String[] subtraction = br.readLine().split("-");

        int ans = 0;
        boolean isFirst = true;

        for (int i = 0; i < subtraction.length; i++) {

            String[] addition = subtraction[i].split("\\+");
            int sum = 0;
            for (String s : addition) {
                sum += Integer.parseInt(s);
            }
            if (isFirst) {
                ans = sum;
                isFirst = false;

            } else
                ans -= sum;

        }


        System.out.println(ans);
    }

}
