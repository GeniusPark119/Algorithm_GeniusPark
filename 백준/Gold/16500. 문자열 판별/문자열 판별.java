import java.io.*;
import java.util.*;

public class Main {

    static Set<String> set;
    static int[] dp = new int[101];

    public static void main(String[] args) throws IOException {

        set = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int len = target.length();
        int N = Integer.parseInt(br.readLine());


        while(N-->0){
            set.add(br.readLine());
        }

        for(int i=len-1;i>=0;i--){
            for(int j=i+1;j<len;j++){
                if(dp[j]==1){
                    if(set.contains(target.substring(i,j))){
                        dp[i]=1;
                    }
                }
            }
            if(set.contains(target.substring(i))){
                dp[i]=1;
            }
        }
        System.out.print(dp[0]);
    }
}