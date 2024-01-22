// 시작글짜가 끝말이랑 같지 않을때
// 중복되었을 때

import java.util.List;
import java.util.ArrayList;

class Solution {
    List<String> list;
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        list = new ArrayList<>();
        
        char last = words[0].charAt(words[0].length()-1);
        list.add(words[0]);
        for(int i=1;i< words.length;i++){
            if(words[i].charAt(0)!=last || list.contains(words[i])){
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
            last = words[i].charAt(words[i].length()-1);
            list.add(words[i]);
        }
        return answer;
    }
}