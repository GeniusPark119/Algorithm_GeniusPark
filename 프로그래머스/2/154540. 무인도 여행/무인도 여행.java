import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    String[] maps;
    boolean[][] visited;
    int[] dx = { -1,1,0,0}; // 상하좌우
    int[] dy = {0,0,-1,1};
    List<Integer> list = new ArrayList<>();
    public int[] solution(String[] maps) {
        int[] answer = {};
        this.maps = maps;
        visited = new boolean[maps.length][maps[0].length()];
        //  map을 순회하면서 숫자가 나오면 해당 bfs를 진행해서 list에 더해준다.
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)!='X'&&!visited[i][j]) {
                    list.add(bfs(new Pos(i,j,maps[i].charAt(j)-'0')));
                }
            }
        }
        //list가 비어있다면 -1 return 
        if(list.isEmpty()) 
            return new int[]{-1};
        
        // list 크기에 맞는 answer 배열을 만들고 정렬한다.
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    public int bfs(Pos start){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(start);
        int food = 0;
        
        visited[start.x][start.y] = true; // queue offer 뒤에는 무조건 방문철이
        
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            
            
            food += now.food;
            
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(0<= nx && nx < maps.length && 0<=ny && ny<maps[0].length() &&
                  !visited[nx][ny] && maps[nx].charAt(ny)!='X'){
                    // 사방탐색할때 방문체크 필수
                    queue.offer(new Pos(nx,ny,maps[nx].charAt(ny)-'0'));
                    // System.out.println(maps[nx].charAt(ny)-'0');
                    visited[nx][ny] = true;// queue 넣을 때 방문철이
                }
            } 
           
            
        }
         
        return food;
        
    }
    class Pos{ // 위치와 그위치에 음식량
        int x;
        int y;
        int food;
        
        public Pos(int x , int y , int food){
            this.x = x;
            this.y = y;
            this.food = food;
        }
    }
}