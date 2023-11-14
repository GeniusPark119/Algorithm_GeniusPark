import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private List<Integer> list = new ArrayList<>();
    private Map<Character,Integer> map = new HashMap<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        int todayYear = Integer.valueOf(today.substring(0,4).replaceAll("^[0]",""));
        int todayMonth = Integer.valueOf(today.substring(5,7).replaceAll("^[0]",""));
        int todayDays = Integer.valueOf(today.substring(8,10).replaceAll("^[0]",""));
        
        // System.out.println(todayYear+" "+todayMonth+" "+todayDays);
        for(String x : terms){
            // System.out.println(Integer.valueOf(x.substring(2,x.length())));
            map.put(x.charAt(0),Integer.valueOf(x.substring(2,x.length()))*28);
        }
        for(int i=0;i<privacies.length;i++){
            char promise = privacies[i].charAt(privacies[i].length()-1);
            int pyear = Integer.valueOf(privacies[i].substring(0,4).replaceAll("^[0]",""));
            int pmonth = Integer.valueOf(privacies[i].substring(5,7).replaceAll("^[0]",""));
            int pdays = Integer.valueOf(privacies[i].substring(8,10).replaceAll("^[0]",""));
            // System.out.println(pyear+" "+pmonth+" "+pdays);
            if(((todayYear-pyear)*12+(todayMonth-pmonth))*28 + (todayDays-pdays)>= map.get(promise))
                list.add(i+1);
            
        }
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}