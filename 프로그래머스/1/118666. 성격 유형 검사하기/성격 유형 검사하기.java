import java.util.HashMap;

class Solution {
    private HashMap<Character,Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<survey.length;i++){

            int num = choices[i];
            if(choices[i]<4){
                char personality = survey[i].charAt(0);
                map.put(personality,map.get(personality)+4-num);
            }else if(choices[i]>4){
                char personality = survey[i].charAt(1);
                map.put(personality,map.get(personality)+num-4);
            }else
                continue;
        }
        if(map.get('R')<map.get('T')) 
            sb.append("T");
        else
            sb.append("R");
        
        if(map.get('C')<map.get('F')) 
            sb.append("F");
        else
            sb.append("C");
        
        if(map.get('J')<map.get('M')) 
            sb.append("M");
        else
            sb.append("J");
        
        if(map.get('A')<map.get('N')) 
            sb.append("N");
        else
            sb.append("A");
        
        answer = sb.toString();
        return answer;
    }
}