import java.util.HashSet;
import java.util.Set;

class Solution {
    
    int nowX = 0;
    int nowY = 0;
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    
    public Set<Way> set;
    public int solution(String dirs) {
        int answer = 0;
        set = new HashSet<>();
        
        for(int i=0;i<dirs.length();i++){
            int nextX = 0;
            int nextY=0;
            int flag = 0;
            
            if(dirs.charAt(i)=='U'){
                flag = 0;
            }else if(dirs.charAt(i)=='D'){
                flag = 1;
            }else if(dirs.charAt(i)=='R'){
                flag = 2;
            }else{
                flag = 3;
            }
            
            nextX = nowX + dx[flag];
            nextY = nowY + dy[flag];
            
            if(-5 <= nextX && nextX <= 5 && -5 <= nextY && nextY <= 5){
                boolean isExist =false;
                if(nowX < nextX || ( nowX == nextX && nowY < nextY)){
                    for(Way p : set){
                        if(p.x1 ==nowX && p.y1 == nowY && 
                           p.x2 == nextX && p.y2 == nextY){
                            isExist = true;
                            break;
                        }
                    }
                    if(!isExist)
                    set.add(new Way(nowX,nowY,nextX,nextY));
                }else{
                    for(Way p : set){
                        if(p.x1 == nextX && p.y1 == nextY &&
                           p.x2 == nowX && p.y2 == nowY){
                            isExist = true;
                            break;
                        }
                    }
                    if(!isExist)
                        set.add(new Way(nextX,nextY,nowX,nowY));
                }
                
                nowX += dx[flag];
                nowY += dy[flag];
                
            }
        }
        answer = set.size();
        return answer;
    }
    
    
    public static class Way{
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
    
        public Way(int x1,int y1,int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    
}