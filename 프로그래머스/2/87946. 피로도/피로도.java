class Solution {
    private int[][] dungeons;
    private boolean[] visited;
    private int depth = 0;
    private int max_dep = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        dfs(0,k);
        answer = max_dep;
        return answer;
    }
    private void dfs(int depth,int fatigue){
        if(max_dep == dungeons.length) return;
        for(int i=0;i<dungeons.length;i++){
            if(visited[i] || fatigue<dungeons[i][0]){
                continue;
            }
            visited[i] = true;
            dfs(depth+1,fatigue-dungeons[i][1]);
            visited[i] = false;
        }
        max_dep = Math.max(max_dep,depth); 
        
    }
}