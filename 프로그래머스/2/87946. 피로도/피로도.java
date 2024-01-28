// 입장하기위한 피로도와 깎이는 피로도
// 완전탐색을 한다면?
// dep = 던전의 수일때 다시 되돌아간다.

class Solution {
    static int[][] dungeons;
    static boolean[] visited;
    static int len;
    static int cnt = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        this.dungeons = dungeons;
        len = dungeons.length;
        visited = new boolean[len];
        dfs(0,k);
        answer = cnt;
        return answer;
    }
    public void dfs(int dep,int fatigue){
        for(int i=0;i<len;i++){
            if(visited[i] || dungeons[i][0]>fatigue){
                continue;
            }
            visited[i] = true;
            dfs(dep+1,fatigue-dungeons[i][1]);
            visited[i] = false;
        }
        cnt = Math.max(cnt,dep);
        
        
    }
}