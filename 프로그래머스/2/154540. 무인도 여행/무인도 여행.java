import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    String[] maps;
    boolean[][] visited;
    int[] dx = { -1,1,0,0};
    int[] dy = {0,0,-1,1};
    List<Integer> list = new ArrayList<>();
    public int[] solution(String[] maps) {
        int[] answer = {};
        visited = new boolean[maps.length][maps[0].length()];
        this.maps = maps;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(!visited[i][j] && maps[i].charAt(j)!='X'){
                    visited[i][j] = true;
                    
                    list.add(dfs(new Pos(i,j,maps[i].charAt(j)-'0')));
                }
            }
        }
        if(list.isEmpty())
            return new int[]{-1};
        list.sort(Comparator.naturalOrder());
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]= list.get(i);
        }
        return answer;
    }
    public int dfs(Pos pos){
        int food = pos.food;
        
        for(int i=0;i<4;i++){
            int nx = pos.x + dx[i];
            int ny = pos.y + dy[i];
            
            if(0<=nx && nx < maps.length && 0<=ny && ny < maps[0].length() 
               && !visited[nx][ny]
              && maps[nx].charAt(ny) !='X'){
                visited[nx][ny] = true;
                food +=dfs(new Pos(nx,ny,maps[nx].charAt(ny)-'0'));
            }

        }
        return food;
    }
    
    class Pos{
        int x;
        int y;
        int food;
        
        public Pos(int x,int y,int food){
            this.x = x;
            this.y = y;
            this.food = food;
        }
    }
}