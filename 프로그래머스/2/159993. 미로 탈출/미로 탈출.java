import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static class Pointer{ // 지점의 좌표와 지점별 도달 시간
        int i;
        int j;
        int time;
        
        Pointer(int i,int j,int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
    String[] maps;
    Pointer lavor,start,end; // 레버,시작,끝 지점
    Queue<Pointer> queue; // bfs를 위한 큐
    boolean[][] visited; // 지나친 곳인가 true로 표기
    int[] di = {-1,1,0,0}; // 상 하 좌 우
    int[] dj = {0,0,-1,1}; // 상 하 좌 우
    int len_i,len_j; // 미로의 세로길이,가로길이
    
    public int solution(String[] maps) {
        int answer = 0;
        this.maps = maps;
        len_i = maps[0].length(); // 미로의 세로길이
        len_j = maps.length; // 미로의 가로길이
        visited = new boolean[maps.length][maps[0].length()]; // 지나친 곳인가 true로 표기       
        queue = new LinkedList<>(); // bfs
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)=='S'){
                    start = new Pointer(i,j,0);
                }else if(maps[i].charAt(j)=='E'){
                    end = new Pointer(i,j,0);
                }else if(maps[i].charAt(j)=='L'){
                    lavor = new Pointer(i,j,0);
                }
            }
        } // start end lavor 모두 pointer 클래스로 찾아놓는다.

        queue.offer(start);// 큐에 시작 포인터를 저장한다.
        visited[start.i][start.j] = true;
        
        while(!queue.isEmpty()){ // 큐가 비워질때까지 반복한다.
            Pointer p = queue.poll();
            
            if(p.i==lavor.i && p.j == lavor.j) {
                lavor.time = p.time;
                return findEnd();
            }
            for(int i=0;i<4;i++){
                int ni = p.i+di[i];
                int nj = p.j+dj[i];
                if(isin(ni,nj) && !visited[ni][nj]){
                    if(maps[ni].charAt(nj)!='X') {
                        queue.offer(new Pointer(ni,nj,p.time+1));
                        visited[ni][nj] = true;
                    }
                }
            }
            
        }
        return -1;
    }
    
    public boolean isin(int i,int j){
        return 0<=i && i<len_j && 0<=j && j<len_i;
    }
    
    public int findEnd(){
        queue = new LinkedList<>();
        visited = new boolean[len_j][len_i];
        
        queue.offer(lavor);
        visited[lavor.i][lavor.j] = true;
        
        while(!queue.isEmpty()){
            Pointer p = queue.poll();
            if(p.i==end.i && p.j == end.j) return p.time;
            for(int i=0;i<4;i++){
                int ni = p.i + di[i];
                int nj = p.j + dj[i];
                
                if(isin(ni,nj) && !visited[ni][nj]){
                    if(maps[ni].charAt(nj)!='X'){
                        queue.offer(new Pointer(ni,nj,p.time+1));
                        visited[ni][nj] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}