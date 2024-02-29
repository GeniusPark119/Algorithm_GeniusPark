import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        loop:
        for (int i = 0; i < tc; i++) {
            dq = new LinkedList<>();
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                String arrStr = br.readLine();
                String[] arr = arrStr.substring(1, arrStr.length() - 1).split(",");

                for (String x : arr) {
                    if (!x.isEmpty())
                        dq.offerLast(Integer.parseInt(x));
                }
            }else{
                br.readLine();
            }
            boolean reverse = false;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (dq.isEmpty()) {
                        sb.append("error\n");
                        continue loop;
                    } else {
                        if (reverse)
                            dq.pollLast();
                        else
                            dq.pollFirst();
                    }
                }
            }
            if (reverse) {
                sb.append("[");
                while (!dq.isEmpty()) {
                    sb.append(dq.pollLast());
                    if (dq.isEmpty())
                        break;
                    sb.append(",");
                }
                sb.append("]\n");
            } else {
                sb.append("[");
                while (!dq.isEmpty()) {
                    sb.append(dq.pollFirst());
                    if (dq.isEmpty())
                        break;
                    sb.append(",");
                }
                sb.append("]\n");
            }
        }

        System.out.println(sb);
    }

}


