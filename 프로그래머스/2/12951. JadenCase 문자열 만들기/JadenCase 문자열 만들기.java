class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        String[] strs = s.split("");
        
        boolean Upper = true;
        StringBuilder sb = new StringBuilder();
        
        for(String str : strs){
            if(Upper) {
                sb.append(str.toUpperCase());
                Upper = false;
            }else{
                sb.append(str);
            }
            
            Upper = str.equals(" ")? true:false;
            
        }
        answer =sb.toString();
        return answer;
    }
}