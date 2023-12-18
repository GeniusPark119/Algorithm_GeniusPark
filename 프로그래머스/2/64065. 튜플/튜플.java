//231218 15시 50분
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> list = new ArrayList<>();
    public List<Integer> tmpList = new ArrayList<>();
    public int[] solution(String s) {
        int[] answer = {};
        s = s.replaceAll("},","-");
        // System.out.println(s);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=2;i<s.length()-1;i++){
            
            char tmp = s.charAt(i);
            if('0'<=tmp&&tmp<='9') sb.append(tmp);
            if(tmp==','||tmp=='-'||tmp=='}'){
                tmpList.add(Integer.valueOf(sb.toString()));
                sb.setLength(0);
            }
            if(tmp=='{'){
                list.add(tmpList);
                tmpList = new ArrayList<>();
            }

            if(i==s.length()-2) list.add(tmpList);
        }
        
        list.sort((o1,o2)->(o1.size()-o2.size()));
            // System.out.println(list);
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            if(i==0){
                answer[i] = list.get(i).get(i);
                continue;
            }
            for(int j=0;j<list.get(i).size();j++){
                if(!list.get(i-1).contains(list.get(i).get(j))){
                    answer[i] = list.get(i).get(j);
                }
            }
        }
        
        return answer;
    }
}

