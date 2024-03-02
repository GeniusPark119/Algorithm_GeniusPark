import java.io.*;
import java.util.*;

public class Main {

    static String[] arr = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int ans1 = 0;
        int ans2 = 0;
        long ans3 = 0;

        for(int i=0;i<10;i++){
            if(str1.equals(arr[i])){
                ans1 = i;
            }
            if(str2.equals(arr[i])){
                ans2 = i;
            }
            if(str3.equals(arr[i])){
                ans3 = (long)Math.pow(10,i);
            }
        }
        sb.append(ans1);
        sb.append(ans2);

        System.out.println(Integer.parseInt(sb.toString())*ans3);





    }
}


