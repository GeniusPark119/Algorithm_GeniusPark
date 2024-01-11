import java.util.List;
import java.util.ArrayList;

class Solution {
    
    boolean[][] visited;
    int[][] board_maps;
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    List<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        board_maps = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        // maps 배열을 int 배열로 하고 x인 부분을 0으로 함과 동시에 visited true로 체크한다.
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)=='X'){
                    visited[i][j] = true;
                    board_maps[i][j] = 0;
                }   
                else 
                    board_maps[i][j] = maps[i].charAt(j)-'0';
            }
        }
        
        for(int i=0;i<board_maps.length;i++){
            for(int j=0;j<board_maps[0].length;j++){
                System.out.print(board_maps[i][j]);
            }
            System.out.println();
        }
        
        findFood();
        
        // list -> answer
        if(list.isEmpty()) list.add(-1);
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void findFood(){
        for(int i=0;i<board_maps.length;i++){
            for(int j=0;j<board_maps.length;j++){
                if(board_maps[i][j]!=0 && !visited[i][j]){
                   list.add(sumOfFood(i,j));
                }
            }
        }
    }
    public int sumOfFood(int x,int y){
        int answer = 0;
        if(board_maps[x][y] == 0) return 0;
        
        for(int i=0;i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(inRange(nextX,nextY) && !visited[nextX][nextY]){
                visited[nextX][nextY] = true;
                answer += Integer.valueOf(board_maps[x][y]) + sumOfFood(nextX,nextY);
            }
        }
        
        return answer;
    }
    public boolean inRange(int x,int y){
        return x>=0 && x<board_maps.length && y>=0 && y<board_maps[0].length;
    }
}