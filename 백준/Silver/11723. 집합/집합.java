import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> set;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        set = new HashSet<>();
        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            if (str.equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (str.equals("empty")) {
                set.clear();
            } else {
                int num = Integer.parseInt(st.nextToken());
                if (str.equals("add")) {
                    set.add(num);
                } else if (str.equals("remove")) {
                    if (set.contains(num))
                        set.remove(num);
                } else if (str.equals("check")) {
                    if (set.contains(num)) {

                        sb.append(1);
                        sb.append("\n");
                    } else {

                        sb.append(0);
                        sb.append("\n");
                    }
                } else {
                    if (set.contains(num))
                        set.remove(num);
                    else
                        set.add(num);

                }

            }

        }

        System.out.println(sb.toString());

    }
}
