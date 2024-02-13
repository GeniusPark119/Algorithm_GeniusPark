import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


//직각삼각형

public class Main {
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;
    static List<Integer> list;
    public static void main(String[] args) {
        pq = new PriorityQueue<>();
        list = new ArrayList<>();
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
