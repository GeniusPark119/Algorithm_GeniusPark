import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        this.maps = maps;
        visited = new boolean[maps.length][maps[0].length];
        answer = bfs(0,0);
        return answer;
    }
    public int bfs(int a,int b){
        visited[a][b] = true;
        Queue<Pointer> queue = new LinkedList<>();
        queue.add(new Pointer(a,b,1));
        
        while(!queue.isEmpty()){
            Pointer point = queue.poll();
            int x = point.x;
            int y = point.y;
            int dep = point.dep;
            
            if(x == maps.length-1 && y == maps[0].length-1)
                return dep;
            
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(0<= nx && nx <maps.length && 0<=ny && ny<maps[0].length 
                   && maps[nx][ny] == 1
                   && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new Pointer(nx,ny,dep+1));
                }
            }
            
        }
        
        return -1;
        
    }
    
    class Pointer{
        int x = 0;
        int y = 0;
        int dep = 0;
        
        public Pointer(int x,int y,int dep){
            this.x = x;
            this.y = y;
            this.dep =dep;
        }
    }
}