// Enter => 들어왔습니다.
// Leave => 나갔습니다.
// Change => 찍히는 거 없이 오직 닉네임 변경만
// HashMap을 사용해서 아이디=닉네임

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    class User{
        String action = "";
        String id = "";
        
        public User(String action,String id){
            this.action = action;
            this.id = id;
        }
    }
    public Map<String,String> map = new HashMap<>();
    public List<User> list = new ArrayList<>();
    public String[] solution(String[] record) {
        String[] answer = {};
        
        for(String str : record){
            String[] arr = str.split(" ");
            // System.out.println(Arrays.toString(arr));
            if(!arr[0].equals("Change"))
                list.add(new User(arr[0],arr[1]));
            if(!arr[0].equals("Leave")) 
                map.put(arr[1],arr[2]);
        }
        
        answer = new String[list.size()];
        
        for(int i=0;i<list.size();i++){
            if(list.get(i).action.equals("Enter"))
                answer[i] = map.get(list.get(i).id)+"님이 들어왔습니다.";
            else if(list.get(i).action.equals("Leave"))
                answer[i] = map.get(list.get(i).id)+"님이 나갔습니다.";
        }
        
        return answer;
    }
}