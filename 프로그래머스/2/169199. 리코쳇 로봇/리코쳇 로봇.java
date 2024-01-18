// 시작위치에서 뻗어나가면서 결국 도착위치에 도달해야하며 그 짧은 길을 찾아야한다.
// 따라서 bfs를 통해 이동의 수를 세며 최소값을 구한다.
// 그렇다면 아예 길이 없는 경우에 어떻게 알 수 있을까?
// 방문 체크를 하면서 이미 방문했다면 굳이 해당 길을 갈 필요가 없다. 같거나 더 짧은 경로로 이미 있는것이니까
// 그렇게 방문을 한 곳만 남아있고 bfs식이 끝나지 않았다면 더이상 경로가 없다고 생각해도 된다.

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    String[] board;
    int[] dx = {-1,1,0,0};//상하좌우
    int[] dy = {0,0,-1,1};//상하좌우

    public boolean[][] visited;
    Pos start,end;
    public int solution(String[] board) {
        int answer = 0;
        visited = new boolean[board.length][board[0].length()];
        this.board = board;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                char word = board[i].charAt(j);
                if(word=='R') 
                    start = new Pos(i,j,0);
                else if(word=='G')
                    end = new Pos(i,j,0);
                
            }
        }
        
        answer = bfs(start);
        
        return answer;
    }
    public int bfs(Pos pos){

        Queue<Pos> queue  = new LinkedList<>();
        queue.offer(pos);
        visited[pos.x][pos.y] = true;
        
        while(!queue.isEmpty()){
            Pos p = queue.poll();
            
            for(int i=0;i<4;i++){
                int nx = p.x;
                int ny = p.y;
                while(0<=nx+dx[i] && nx+dx[i]<board.length &&
                      0<=ny+dy[i] && ny+dy[i]<board[0].length() &&
                     board[nx+dx[i]].charAt(ny+dy[i]) !='D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                if(nx==end.x && ny == end.y) return p.level+1;
                if(!visited[nx][ny]){
                    queue.offer(new Pos(nx,ny,p.level+1));
                    visited[nx][ny] = true;
                }
                
            }
            
        }
        
        return -1;
        
    }
    
    class Pos{ // 좌표를 나타내는 클래스로 x좌표 y좌표와 이제까지 이동한 횟수를 저장한다.
        int x;
        int y;
        int level;//이동한 수
        
        public Pos(int x,int y,int level){
            this.x = x;
            this.y = y;
            this.level =level;
        }
    }
}