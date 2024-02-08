// 16:55
// bfs 이라생각했는데 dfs인가? 최소거리이니까 bfs일거같은데
// 글자가 하나만 틀리면 1씩 더한다.

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static Queue<WordCnt> queue;
    static boolean[] visited;
    static String[] words;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        this.words = words;
        answer = bfs(begin,target);
        return answer;
    }
    
    public boolean isNext(String str1,String str2){ 
        // str1이랑 str2가 서로 다음단계가 될 수 있는지
        int cnt = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i))
                cnt++;
            if(cnt>=2) return false;
        }
        if(cnt==1) return true;
        return false;
        
    }
    
    public int bfs(String begin,String target){
        queue = new LinkedList<>();
        queue.offer(new WordCnt(begin,0));
        int minCnt = 0;
        while(!queue.isEmpty()){
            WordCnt before = queue.poll();

            for(int i=0;i<words.length;i++){
                if(!visited[i] && isNext(before.str,words[i])){
                    if(words[i].equals(target))
                        return before.cnt+1;
                    visited[i] = true;
                    queue.offer(new WordCnt(words[i],before.cnt+1));
                }
             } 
        }
        
        return 0;
    }
    
    static class WordCnt{
        String str;
        int cnt;
        
        public WordCnt(String str,int cnt){
            this.str = str;
            this.cnt = cnt;
        }
    }
}