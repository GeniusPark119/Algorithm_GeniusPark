import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main {
    static Set<String> set;
    public static void main(String[] args) {
        set = new HashSet<>();
        Scanner sc  = new Scanner(System.in);
        int cnt = sc.nextInt();
        for(int i=0;i<cnt;i++){
            set.add(sc.next());
        }
        String[] arr = new String[set.size()];
        int idx = 0;

        for(String s :set){
            arr[idx++] = s;
        }

        Arrays.sort(arr);

        Arrays.sort(arr,(a,b)-> a.length()-b.length());

        for(String s : arr){
            System.out.println(s);
        }


    }
}