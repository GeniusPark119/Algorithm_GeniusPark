import java.util.Scanner;
import java.util.Arrays;

//숫자카드 2

//10
//6 3 2 10 10 10 -10 -10 7 3
//8
//10 9 -5 2 3 4 5 -10

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 배열의 개수를 구하고 배열을 완성시킨다.
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // 이분 탐색 전에 정렬을 해준다.

//        System.out.println(Arrays.toString(arr));

        int n2 = sc.nextInt();

        sb = new StringBuilder();

        for(int i=0;i<n2;i++){
            int key = sc.nextInt();
//            System.out.println("key"+key);
            sb.append(String.valueOf(findR(arr,key)-findL(arr,key)));
            sb.append(' ');

        }
        System.out.println(sb.toString());
    }

    public static int findL(int[] arr,int key){ // 왼쪽 구하기
        int left = 0;
        int right = arr.length;

        while(left<right) {
            int mid = (left+right)/2;

            if(arr[mid]>=key){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    public static int findR(int[] arr,int key){
        int left = 0;
        int right = arr.length;

        while(left<right){
            int mid = (left+right)/2;

            if(key < arr[mid]){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }

}
