import java.util.List;
import java.util.ArrayList;

class Solution {
    static List<String> list1;
    static List<String> list2;
    public int solution(String str1, String str2) {
        int answer = 0;
        
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        for(int i=0;i<str1.length()-1;i++){
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            
            if('A'<=first && first <='Z' && 
               'A' <= second && second <='Z'){
                list1.add(""+first+second);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            
            if('A'<=first && first <='Z' && 
               'A' <= second && second <='Z'){
                list2.add(""+first+second);
            }
        }
        if(list1.size()==0 && list2.size()==0) return 65536;
        // System.out.println(list1);
        // System.out.println(list2);
        
        int union = 0;
        int intersec = 0;
        
        int sumList = list1.size()+list2.size();
        
        for(String s : list1){
            if(list2.contains(s)) {
                intersec++;
                list2.remove(s);
                continue;
            }
        }
        
        answer = (int)((double)intersec/(sumList -intersec) *65536);
        
        
        return answer;
    }
}