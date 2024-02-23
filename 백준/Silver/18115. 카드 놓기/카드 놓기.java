import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken()); // 사람수
//
//        for(int i=1;i<=n;i++){
//            deque.offerLast(i);
//        }

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = 1;

        for(int i=n-1;i>=0;i--){
            if(arr[i]==1){
                deque.offerFirst(num);
            }else if(arr[i]==2){
                int tmp = deque.pollFirst();
                deque.offerFirst(num);
                deque.offerFirst(tmp);
            }else{
                deque.offerLast(num);
            }
            num++;
        }
        for(int x : deque){
            sb.append(x+" ");
        }
        System.out.println(sb.toString());
    }
}
