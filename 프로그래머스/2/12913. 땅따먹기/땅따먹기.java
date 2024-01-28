//2행부터 N행까지 최대값을 구한다.

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] map = new int[land.length][4];
        
        for(int i=0;i<map.length;i++){
            if(i==0){
                map[i][0] = land[0][0];
                map[i][1] = land[0][1];
                map[i][2] = land[0][2];
                map[i][3] = land[0][3];
                continue;
            }
            map[i][0] = land[i][0] + Math.max(Math.max(map[i-1][1],map[i-1][2]),map[i-1][3]);
            map[i][1] = land[i][1] + Math.max(Math.max(map[i-1][0],map[i-1][2]),map[i-1][3]);
            map[i][2] = land[i][2] + Math.max(Math.max(map[i-1][1],map[i-1][0]),map[i-1][3]);
            map[i][3] = land[i][3] + Math.max(Math.max(map[i-1][1],map[i-1][2]),map[i-1][0]);
            
            
            if(i==map.length-1){
                answer = Math.max(Math.max(map[i][0],map[i][1]),Math.max(map[i][2],map[i][3]));
            }
        }

        return answer;
    }
}