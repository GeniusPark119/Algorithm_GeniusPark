import java.io.*;
import java.util.*;

public class Main {

    static Set<Integer> set;
    static List<Integer> list;

    static Map<Integer,Integer> map;

    public static void main(String[] args) throws IOException {

        set = new HashSet<>();
        map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
            arr[i] = num;
        }

        list = new ArrayList<>(set);

        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            map.put(list.get(i),i);
        }

        for(int x : arr){
            sb.append(map.get(x));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

}


