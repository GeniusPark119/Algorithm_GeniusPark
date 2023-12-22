import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> list1 = new ArrayList<>();
    public List<String> list2 = new ArrayList<>();
    
    public int solution(String str1, String str2) {
        int answer = 0;
        String s1 = str1.replaceAll("[^a-zA-Z]","-");
        String s2 = str2.replaceAll("[^a-zA-Z]","-");
        // System.out.println(s1+" "+s2);
        
        for(int i=0;i<s1.length()-1;i++){
            if(s1.charAt(i)=='-'||s1.charAt(i+1)=='-') continue;
            list1.add((s1.charAt(i)+""+s1.charAt(i+1)).toUpperCase());
        }
        for(int i=0;i<s2.length()-1;i++){
            if(s2.charAt(i)=='-'||s2.charAt(i+1)=='-') continue;
            list2.add((s2.charAt(i)+""+s2.charAt(i+1)).toUpperCase());
        }
        // System.out.println(list1);
        // System.out.println(list2);
        
        if(list1.size()==0 && list2.size()==0) return 65536;
        
        int same_cnt = 0;
        
        boolean[] checked = new boolean[list2.size()];
        
        for(String x1 : list1){
            // System.out.println("x1"+x1);
            for(int i=0;i<list2.size();i++){
                if(x1.equals(list2.get(i))){
                    if(checked[i]==false){
                        same_cnt++;
                        // System.out.println("i"+i);
                        checked[i]=true;
                        break;
                    }
                }
            }
        }
        
//         System.out.println(same_cnt);
        
//         System.out.println((double)same_cnt/(list1.size()+list2.size() - same_cnt));
        
        answer = (int)(((double)same_cnt/(list1.size()+list2.size() - same_cnt))*65536);
        
        return answer;
    }
}