import java.util.HashSet;
class Solution {
    public HashSet<String> set = new HashSet<>();
    public boolean solution(String[] phone_book) {
        
        boolean answer = true;
        for(String number : phone_book){
            set.add(number);
        }
        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<phone_book[i].length();j++){
                if(set.contains(phone_book[i].substring(0,j))) return false;
            }

        }
        
            
        return true;
    }
}