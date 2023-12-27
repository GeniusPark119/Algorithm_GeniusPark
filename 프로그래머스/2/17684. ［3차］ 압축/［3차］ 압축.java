import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


//A~Z 아스키코드 65~90

class Solution {
    Map<String,Integer> map = new HashMap<>(); // 단어 = 색인번호
    List<Integer> list = new ArrayList<>(); // answer 를 위한 list
    int next_num = 27;
    public int[] solution(String msg) {
        int[] answer = {};
        for(int i=65;i<=90;i++){
            map.put(""+(char)i,i-64);
        }
        // System.out.println(map);
        lzw(msg);
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]= list.get(i);
        }
        return answer;
    }
    public void lzw(String msg){// 색인번호 구하기
        int start = 0;
        int end = 0;
        while(start < msg.length()){
            while(end<msg.length() && map.containsKey(msg.substring(start,end+1))){
                end ++;
            }
            list.add(map.get(msg.substring(start,end)));
            if(end+1>msg.length()) break;
            map.put(msg.substring(start,end+1),next_num++);
            start = end;
        }
    }
}