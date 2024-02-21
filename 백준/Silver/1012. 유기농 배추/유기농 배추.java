import java.util.Scanner;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int[][] board;
    static boolean[][] visited;
    static int m,n;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int i=0;i<tc;i++){
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            board = new int[m][n];
            visited = new boolean[m][n];

            for(int j=0;j<k;j++){
                board[sc.nextInt()][sc.nextInt()] =1;
            }

            int count = 0;

            for(int j=0;j<m;j++){
                for(int l=0;l<n;l++){
                    if(board[j][l]==1 && !visited[j][l]){
                        dfs(j,l);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }

    }
    static void dfs(int x,int y){
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0<=nx && nx<m && 0<=ny && ny <n && board[nx][ny]==1 && !visited[nx][ny] ){
                dfs(nx,ny);
            }
        }
    }




}
