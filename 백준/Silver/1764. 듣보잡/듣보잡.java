import java.io.*;
import java.util.*;

public class Main {

    static Set<String> set;
    static List<String> bothList;

    public static void main(String[] args) {

        set = new HashSet<>();
        bothList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0;i<n;i++){
            set.add(sc.next());
        }

        for(int i=0;i<m;i++){
            String name = sc.next();
            if(set.contains(name))
                bothList.add(name);
        }

        Collections.sort(bothList);

        System.out.println(bothList.size());

        for(String s : bothList)
            System.out.println(s);

    }
}
