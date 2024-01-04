class Solution {
    static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	public static int solution(String dirs) {
		int answer = 0;
		int map[][] = new int[11][11];
		boolean visit[][][] = new boolean[11][11][4];
		int r = 5, c = 5;
		for (int i = 0; i < dirs.length(); i++) {
			char cc = dirs.charAt(i);
			int d = 0;
			if (cc == 'U')
				d = 0;
			if (cc == 'L')
				d = 1;
			if (cc == 'D')
				d = 2;
			if (cc == 'R')
				d = 3;
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= 11 || nc >= 11)
				continue;
			if (!visit[nr][nc][d]) {
				visit[nr][nc][d] = true;
				d = (d%2 == 0)? 2-d: 4-d;
				visit[r][c][d] = true;
				answer++;
			}
			r = nr;
			c = nc;
		}
		System.out.println(answer);
		return answer;
	}
}

// import java.util.HashSet;
// import java.util.Set;

// class Solution {
//     public static class Way{
//         int x1 = 0;
//         int y1 = 0;
//         int x2 = 0;
//         int y2 = 0;
        
//         public Way(int x1,int y1,int x2,int y2){
//             this.x1 = x1;
//             this.y1 = y1;
//             this.x2 = x2;
//             this.y2 = y2;
            
//         }
//     }
    
//     int nowX = 0;
//     int nowY = 0;
//     int[] dx = {0,0,1,-1}; // UDRL
//     int[] dy = {1,-1,0,0};
    
//     public Set<Way> set = new HashSet<>();
//     public int solution(String dirs) {
//         int answer = 0;
//         for(int i=0;i<dirs.length();i++){
            
//             int nextX = 0;
//             int nextY = 0;
//             int flag = 0;
            
//             if(dirs.charAt(i)=='U'){
//                 flag = 0;
//             }else if(dirs.charAt(i)=='D'){
//                 flag = 1;
//             }else if(dirs.charAt(i)=='R'){
//                 flag = 2;
//             }else{
//                 flag = 3;
//             }
            
//             nextX = nowX + dx[flag];
//             nextY = nowY + dy[flag];
            
//             if(inRange(nextX,nextY)){
//                 boolean isExist =false;
//                 if(nowX<nextX || (nowX==nextX && nowY<nextY)){
//                     for(Way p : set){
//                         if(p.x1==nowX && p.y1==nowY && p.x2 == nextX 
//                            && p.y2==nextY){
//                             isExist = true;
//                             break;
//                         }
//                     }
//                     if(!isExist)
//                     set.add(new Way(nowX,nowY,nextX,nextY));
//                 }else {
//                     for(Way p : set){
//                         if(p.x1==nextX && p.y1==nextY && p.x2 == nowX 
//                            && p.y2==nowY){
//                             isExist = true;
//                             break;
//                         }
//                     }
//                     if(!isExist)
//                     set.add(new Way(nextX,nextY,nowX,nowY));
//                 }
//                 nowX += dx[flag];
//                 nowY += dy[flag];
//             }
               
            
//         }
//         answer = set.size();
//         return answer;
//     }
    
//     public static boolean inRange(int x,int y){
//         return x>=-5 && y>=-5 && x <=5 && y<=5;
//     }
// }