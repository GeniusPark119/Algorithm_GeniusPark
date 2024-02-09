import java.util.Scanner;
//import java.util.Arrays;
// 왼쪽 위에서부터 8칸이 되는곳까지 체스판을 잡아보기
// 처음이 W인 경우와 B인경우를 나눠서 몇개 칠해야하는지 보기

public class Main {
    public static void main(String[] args) {

        int answer = Integer.MAX_VALUE;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] board = new char[n][m];

        for(int i=0;i<n;i++){
            String str = sc.next();
            for(int j=0;j<m;j++){
                board[i][j] = str.charAt(j);
            }
        }

        // 두개의 경우의 수가 있음 처음이 W 처음이 B
        // 처음이 W 이면 ->

        for(int i=0;i<n-7;i++){
            for(int j=0;j<m-7;j++){
                //start 좌표 (i, j) 를 잡았다.

                int startW = 0;
                int startB = 0;

                //1. 처음이 W로 시작할 경우
                for(int a=i;a<i+8;a++){
                    for(int b=j;b<j+8;b++){
                        if(a%2==b%2){
                            if(board[a][b]!='W') startW++;
                            else startB++;
                        }else{
                            if(board[a][b]!='B') startW++;
                            else startB++;
                        }
                    }
                }
                answer = Math.min(answer,Math.min(startW,startB));
            }
        }


//        return answer;
        System.out.println(answer);


    }
}