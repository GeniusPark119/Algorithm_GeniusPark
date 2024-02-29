import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list;

    static Map<Integer,Integer> map;

    public static void main(String[] args) throws IOException {

        map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; // 원본
        int[] arrSorted = new int[n]; // 정렬된 원본

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            arrSorted[i] = num;
        }

        Arrays.sort(arrSorted);

        int cnt = 0;

        for(int i=0;i<n;i++){
            if(!map.containsKey(arrSorted[i])){
                map.put(arrSorted[i],cnt);
                cnt++;
            }
        }

        for(int x : arr){
            sb.append(map.get(x));
            sb.append(" ");
        }
        System.out.println(sb);
    }

}


