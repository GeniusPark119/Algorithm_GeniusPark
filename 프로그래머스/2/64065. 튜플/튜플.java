import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution{
    public Set<String> set = new HashSet<>();
    public int[] solution(String s){
        int[] answer ={};
        String[] arr = s.replaceAll("[{}]"," ").trim().split(" , ");
        Arrays.sort(arr,(s1,s2)->s1.length()-s2.length());
        
        answer = new int[arr.length];
        int idx = 0;
        for(String str : arr){
            for(String num : str.split(",")){
                if(set.add(num)) answer[idx++] = Integer.valueOf(num);
            }
            
        }
        
    
        return answer;
    }
}


























// //231218 15시 50분 ~ 21시 (3시간(식사시간포함))
// import java.util.List;
// import java.util.ArrayList;

// class Solution {
//     public List<List<Integer>> list = new ArrayList<>();
//     public List<Integer> tmpList = new ArrayList<>();
//     public int[] solution(String s) {
//         int[] answer = {};
//         s = s.replaceAll("},","-");
//         // System.out.println(s);
        
//         StringBuilder sb = new StringBuilder();
        
//         for(int i=2;i<s.length()-1;i++){
            
//             char tmp = s.charAt(i);
//             if('0'<=tmp&&tmp<='9') sb.append(tmp);
//             if(tmp==','||tmp=='-'||tmp=='}'){
//                 tmpList.add(Integer.valueOf(sb.toString()));
//                 sb.setLength(0);
//             }
//             if(tmp=='{'){
//                 list.add(tmpList);
//                 tmpList = new ArrayList<>();
//             }

//             if(i==s.length()-2) list.add(tmpList);
//         }
        
//         list.sort((o1,o2)->(o1.size()-o2.size()));
//             // System.out.println(list);
        
//         answer = new int[list.size()];
//         for(int i=0;i<list.size();i++){
//             if(i==0){
//                 answer[i] = list.get(i).get(i);
//                 continue;
//             }
//             for(int j=0;j<list.get(i).size();j++){
//                 if(!list.get(i-1).contains(list.get(i).get(j))){
//                     answer[i] = list.get(i).get(j);
//                 }
//             }
//         }
        
//         return answer;
//     }
// }

