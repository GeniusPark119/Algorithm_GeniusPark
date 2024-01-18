// 시작 -> 레버로 가는 bfs + 레버 -> 출구로 가는 bfs
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    String[] maps;
    int[] dx = {-1,1,0,0};//상하좌우
    int[] dy = {0,0,-1,1};
    Pos start,labor,end;
    public int solution(String[] maps) {
        int answer = 0;
        this.maps = maps;
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)=='S')
                    start = new Pos(i,j,0);
                else if(maps[i].charAt(j)=='L')
                    labor = new Pos(i,j,0);
                else if(maps[i].charAt(j)=='E')
                    end = new Pos(i,j,0);
            }
        }
        
        int toL = bfs(start.x,start.y,labor.x,labor.y);
        // System.out.println(start.x+" "+start.y);
        // System.out.println(labor.x+" "+labor.y);
        if(toL==-1) 
            return -1;
        int toE = bfs(labor.x,labor.y,end.x,end.y);
        if(toE == -1) 
            return -1;
        
        answer = toL+toE;
        
        // System.out.println(toL+" "+toE);
        
        return answer;
    }
    public int bfs(int x1,int y1,int x2,int y2){
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited =new boolean[maps.length][maps[0].length()];
        // bfs를 두번 진행해야하므로 visited는 bfs 함수 내에서 선언한다.
        
        queue.offer(new Pos(x1,y1,0)); // queue에 시작지점을 저장한다.
        visited[x1][y1] = true; // queue에 저장한 후 꼭 visited 방문처리
        
        while(!queue.isEmpty()){ // queue에서 더이상 확인할 게 없을 때까지 진행
            Pos now = queue.poll();
            // System.out.println(now.x+" "+now.y+" "+now.level);
            if(now.x == x2 && now.y == y2)
                return now.level;
            
            for(int i=0;i<4;i++){//상하좌우로 이동할 수 있는 지 체크하고 이동한 pos를 queue에 넣기
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(0<=nx && nx < maps.length && 0<=ny && ny < maps[0].length()
                  && !visited[nx][ny] && maps[nx].charAt(ny)!='X'){
                    queue.offer(new Pos(nx,ny,now.level+1)); // 이동한 위치의 Pos를 queue에
                    visited[nx][ny] = true; // queue에 저장한 후 꼭 visited 방문처리
                }
                
            }
        }
        
        // 위 과정에서 결국 답이 안나온채 queue가 비워지면 답이 없다는 뜻이다.
        return -1;
    }
    
    // class Pos를 만들어서 해당 좌표까지 이동한 시간을 누적한다.
    class Pos{
        int x;
        int y;
        int level;
        
        public Pos(int x,int y,int level){
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}