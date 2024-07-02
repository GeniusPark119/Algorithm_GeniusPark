// 2 : 01

class Solution {
    static boolean[] visited;
    static int[][] computers;
    static int answer;
    static int n;
    public int solution(int n, int[][] computers) {
        
        answer = 0;
        visited = new boolean[n];
        this.computers = computers;
        this.n = n;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
    public void dfs(int start){
        visited[start]  = true;
        
        for(int j=0;j<n;j++){
            if(!visited[j] && computers[start][j]==1){
                dfs(j);
            }
        }
    }
}