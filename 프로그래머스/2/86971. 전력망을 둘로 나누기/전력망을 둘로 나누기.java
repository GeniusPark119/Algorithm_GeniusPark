import java.util.List;
import java.util.ArrayList;

class Solution {
    List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] node : wires){
            int v1 = node[0];
            int v2 = node[1];
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        for(int[] node : wires){
            int v1 = node[0];
            int v2 = node[1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            boolean[] visited = new boolean[n+1];
            
            int side1 = dfs(1,visited);
            int side2 = n - side1;
            
            answer = Math.min(answer,(int)Math.abs(side1-side2));
            
            graph[v1].add(v2);
            graph[v2].add(v1);
            
            
        }
        return answer;
    }
    
    public int dfs(int v,boolean[] visited){
        visited[v] = true;
        int cnt = 1;
        
        for(int x : graph[v]){
            if(!visited[x]){
                cnt += dfs(x,visited);
            }
        }
        return cnt;
    }
}
