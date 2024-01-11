import java.util.List;
import java.util.ArrayList;

class Solution {
    
    boolean[][] visited;
    int[][] maps;
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    List<Integer> list = new ArrayList<>();
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        this.maps = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)=='X'){
                    visited[i][j] = true;
                    this.maps[i][j] = 0;
                }   
                else 
                    this.maps[i][j] = maps[i].charAt(j)-'0';
            }
        }
        
        findFood();
        System.out.println(list);
        if(list.isEmpty()) answer = 0;
        return answer;
    }
    public void findFood(){
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length;j++){
                if(maps[i][j]!=0 && !visited[i][j]){
                   list.add(sumOfFood(i,j));
                }
            }
        }
    }
    public int sumOfFood(int x,int y){
        int answer = 0;
        if(maps[x][y] == 0) return 0;
        
        for(int i=0;i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(inRange(nextX,nextY) && !visited[nextX][nextY]){
                visited[nextX][nextY] = true;
                answer += Integer.valueOf(maps[x][y]) + sumOfFood(nextX,nextY);
            }
        }
        
        return answer;
    }
    public boolean inRange(int x,int y){
        return x>=0 && x<maps.length && y>=0 && y<maps.length;
    }
}