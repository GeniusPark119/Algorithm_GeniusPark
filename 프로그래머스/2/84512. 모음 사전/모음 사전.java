import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<String> list;
    static String[] words ={"A","E","I","O","U"};
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("",0);
        for(int i=0;i<list.size();i++){
            // System.out.println(list.get(i));
            if(list.get(i).equals(word)) return i;
        }
        return answer;
    }
    
    public void dfs(String str, int len){
        list.add(str);
        if(len==5) return;
        
        for(int i=0;i<5;i++){
            dfs(str+words[i],len+1);
        }
    }
}

