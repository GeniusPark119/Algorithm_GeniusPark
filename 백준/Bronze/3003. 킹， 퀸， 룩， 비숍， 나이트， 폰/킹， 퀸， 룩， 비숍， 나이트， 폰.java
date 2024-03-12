import java.io.*;
import java.util.*;


public class Main {

    static int[] arr = {1, 1, 2, 2, 2, 8};

    public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<6;i++){

            int num = Integer.parseInt(st.nextToken());

            System.out.print(arr[i]-num+" ");

        }

    }
}
