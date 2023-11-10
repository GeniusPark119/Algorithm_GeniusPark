import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> list = new ArrayList<>();
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        for(int i=0;i<moves.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][moves[i]-1]!=0) {
                    list.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1]=0;
                    break;
                }
            }
        }
        boolean havetwo = true;
        while(havetwo){
            // for(int i=0;i<list.size();i++)
            // System.out.print(list.get(i)+" ");
            // System.out.println();
            havetwo = false;
            for(int i=1;i<list.size();i++){
                if(list.get(i-1) ==list.get(i)) {
                    answer+=2;
                    list.remove(i);
                    list.remove(i-1);
                    havetwo = true;
                    break;
                }
            }                
        }
        return answer;
    }
}