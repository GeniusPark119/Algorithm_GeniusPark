
class Solution{
    public int[][] board;
    public int answer = 0;
    int[][] checked;
    public int solution(int [][]board){
        this.board = board;
        checked = new int[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0 || j==0){
                    checked[i][j] = board[i][j];
                }else if(board[i][j]!=0){
                    checked[i][j] = getMin(i,j)+1;
                }
                answer = Math.max(answer,checked[i][j]);
                // System.out.print(checked[i][j]+" ");
            }
            // System.out.println();
        }
        return (int)Math.pow(answer,2);
    }
    public int getMin(int x,int y){
        return Math.min(Math.min(checked[x-1][y-1],checked[x-1][y]),checked[x][y-1]); 
    }
}