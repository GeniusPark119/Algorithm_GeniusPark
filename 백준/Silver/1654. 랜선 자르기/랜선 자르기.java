import java.util.Scanner;
import java.util.Arrays;

//랜선 자르기

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 배열의 개수를 구하고 배열을 완성시킨다.
        int n = sc.nextInt(); // 4
        int cntLan = sc.nextInt(); // 11
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); //457 539 743 802

        long min = 0;
        long max = (long)arr[arr.length - 1]+1; // 802

        while (min < max) {
            long mid = (min + max) / 2;

            long cnt = 0;

            for (int i = 0; i < n; i++) {
                cnt += arr[i]/mid;
            }

            if(cnt>=(long)cntLan){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        System.out.println(min-1);

    }


}
