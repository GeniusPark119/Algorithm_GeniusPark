import java.util.Queue;
import java.util.LinkedList;
// import java.util.

class Solution {
    
    class Pointer{
        int v;
        int h;
        int time;
        
        public Pointer(int v,int h,int time){
            this.v = v;
            this.h = h;
            this.time = time;
        }
        
    }
    int[][] maps;
    boolean[][] visited;
    Queue<Pointer> queue;
    int[][] delta = {{-1,1,0,0},{0,0,-1,1}}; // dv와 dh 상하좌우
    int len_v,len_h;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        this.maps = maps;
        queue = new LinkedList<>();
        len_v = maps.length;
        len_h = maps[0].length;
        visited = new boolean[len_v][len_h];

        queue.offer(new Pointer(0,0,1));
        visited[0][0] = true;
        answer = bfs();
        return answer;
    }
    
    public int bfs(){
        while(!queue.isEmpty()){
            Pointer p = queue.poll();
            
            if(p.v == len_v-1 && p.h == len_h-1) return p.time;
            
            for(int i=0;i<4;i++){
                int nv = p.v + delta[0][i];
                int nh = p.h + delta[1][i];
                
                if(isin(nv,nh) && !visited[nv][nh] && maps[nv][nh]==1){
                    queue.offer(new Pointer(nv,nh,p.time+1));
                    visited[nv][nh] = true;
                }
            }      
        }
        return -1;
    }
    
    public boolean isin(int nv,int nh){
        return 0<=nv && nv < len_v && 0<=nh && nh < len_h;
    }
}