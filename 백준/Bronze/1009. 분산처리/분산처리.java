import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int data = 1;

            for(int j=0;j<b;j++){
                data *=a;
                data = data%10;
            }

            if(data==0)
                sb.append(10);
            else
                sb.append(data%10);
            sb.append("\n");
        }
//        int ans = 0;


        System.out.println(sb.toString());
    }
}
