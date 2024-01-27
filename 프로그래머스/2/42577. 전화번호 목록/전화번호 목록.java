import java.util.HashSet;
import java.util.Set;

class Solution {
    public Set<String> set;
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        set = new HashSet<>();
        
        for(String str : phone_book){
            set.add(str);
        }
        

        for(int i=0;i<phone_book.length;i++){
            String str = phone_book[i];
            int len = phone_book[i].length();
            for(int j=1;j<len;j++){
               if(set.contains(phone_book[i].substring(0,j))){
                   return false;
               }
            }
        }
        return true;
    }
}