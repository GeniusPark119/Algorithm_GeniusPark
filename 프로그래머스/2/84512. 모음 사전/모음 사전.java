import java.util.List;
import java.util.ArrayList;

class Solution {
    static String[] dictionary = {"A","E","I","O","U"};
    static List<String> list;
    String word;
    int answer;
    public int solution(String word) {
        answer = 0;
        list = new ArrayList<>();
        this.word = word;
        dfs("",0);
        return answer;
    }
    public void dfs(String str , int depth){
        if(answer!=0) return;
        
        if(str.equals(word)) {
            answer=list.size();
            return;
        }
                              
        list.add(str);
        if(depth==5) return;
        for(int i=0;i<5;i++){
            dfs(str+dictionary[i],depth+1);
        }     
    }
}


// import java.util.ArrayList;
// import java.util.List;
// class Solution {
//     static List<String> list;
//     static String [] words = {"A", "E", "I", "O", "U"};
//     public int solution(String word) {
//         int answer = 0;
//         list = new ArrayList<>();
//         dfs("", 0);
//         int size = list.size();
//         for (int i = 0; i < size; i++) {
//             if (list.get(i).equals(word)) {
//                 answer = i;
//                 break;
//             }
//         }
//         return answer;
//     }

//     static void dfs(String str, int len) {
//         list.add(str);
//         if (len == 5) return;
//         for (int i = 0; i < 5; i++) {
//             dfs(str + words[i], len + 1);
//         }
//     }
// }