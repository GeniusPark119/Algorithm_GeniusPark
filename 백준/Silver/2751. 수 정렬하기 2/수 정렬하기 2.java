import java.util.Scanner;
import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;


//직각삼각형

public class Main {
//    static PriorityQueue<Integer> pq;
    static StringBuilder sb;
//    static List<Integer> list;
    public static void main(String[] args) {
//        pq = new PriorityQueue<>();
//        list = new ArrayList<>();
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
//            list.add(sc.nextInt());
            arr[i] = sc.nextInt();
        }
//        Collections.sort(list);

        Arrays.sort(arr);

        for(int x : arr){
            sb.append(x);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
