// 4칸이 정사각형이 되는 경우는 현재,위,왼쪽,왼쪽대각선 위 세군데가 0이 아닐 때이다.
// 4칸이 되는 정사각형의 오른쪽 밑에 수를 2로 바꾸고 계속 하다보면 세 군데중에 가장 작은수가 1일때 4칸이된다.
// 9칸이 되는 정사각형은 현재가 1이고, 왼,위,왼위대각선 이 2로 되어있으면 3*3 정사각형이고 오른쪽 맨 밑 수가 3이다.


class Solution{
    public int solution(int [][]board) {
        int answer = 0;
        
        int[][] checked = new int[board.length][board[0].length];
        
        for(int i=0;i<checked.length;i++){
            for(int j=0;j<checked[0].length;j++){
                if(i==0 || j==0) {
                    checked[i][j] = board[i][j];
                    if(checked[i][j]==1) answer = Math.max(answer,1);
                }else{
                    if(board[i][j]==1){
                        checked[i][j]=Math.min(Math.min(checked[i-1][j-1],checked[i-1][j]),checked[i][j-1])+1;
                        answer = Math.max(answer,checked[i][j]);
                }
                }
            }
        }
        return (int)Math.pow(answer,2);
    }
}