import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 배열의 개수를 구하고 배열을 완성시킨다.
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // 이분 탐색 전에 정렬을 해준다.


        int n2 = sc.nextInt(); // 찾고자하는 숫자의 개수를 구하고 반복문으로 숫자를 찾는다.

        for(int i=0;i<n2;i++){
            int ans = 0;
            int key = sc.nextInt();

            int left = 0; // 시작점
            int right = arr.length-1; // 끝점

            while(left<=right){
                int mid = (left+right)/2; // 중앙

                if(arr[mid]>key){
                    right = mid-1;
                }else if(arr[mid]<key){
                    left = mid+1;
                }else{
                    ans = 1;
                    break;
                }
            }
            System.out.println(ans);
        }




    }
}
