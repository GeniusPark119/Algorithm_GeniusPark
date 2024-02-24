import java.io.*;
import java.util.*;

public class Main {

    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {

        queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){

            arr[i] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(arr);

        int ans = 0;
        int num = 0;

        for(int i=0;i<n;i++){
            num += arr[i];
            ans +=num;
        }

//        for(int x : arr){
//            queue.offer(x);
//        }


        System.out.println(ans);
    }
}
