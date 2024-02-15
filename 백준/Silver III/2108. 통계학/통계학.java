import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


//나이순 정렬

public class Main {

    static int[] arr;
    static int n;

    static List<Cntnum> list;


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(oneAns() + "\n" + twoAns() + "\n" + threeAns() + "\n" + fourAns());

    }

    public static int oneAns() {
        double sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return (int) Math.round(sum / n);
    }

    public static int twoAns() {

        return arr[n / 2];

    }

    public static int threeAns() {

        if (n == 1) return arr[0];

        list = new ArrayList<>();

        int num = arr[0];
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == num) {
                cnt++;
            } else {
                list.add(new Cntnum(num, cnt));
//                System.out.println(num+" "+cnt);
                num = arr[i];
                cnt = 1;
            }
        }
        list.add(new Cntnum(num, cnt));

        Collections.sort(list, (a, b) -> (b.cnt - a.cnt));

        return list.size() == 1 ? list.get(0).num : list.get(0).cnt == list.get(1).cnt ? list.get(1).num : list.get(0).num;

    }

    public static int fourAns() {

        return arr[n - 1] - arr[0];

    }

    static class Cntnum {
        int num = 0;
        int cnt = 0;

        public Cntnum(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
