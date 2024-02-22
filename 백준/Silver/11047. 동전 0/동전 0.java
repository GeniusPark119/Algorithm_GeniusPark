import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list;

    public static void main(String[] args) {

        list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i=0;i<n;i++){
            int value = sc.nextInt();
            if(value<=k)
                list.add(value);
            else
                break;
        }
        Collections.sort(list,(a,b)->b-a);

        int ans = 0;

        for(int i=0;i<list.size();i++){
            ans += k/list.get(i);
            k %=list.get(i);
            if(k==0)
                break;
        }

        System.out.println(ans);


    }
}
