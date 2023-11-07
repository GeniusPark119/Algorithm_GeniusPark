class Solution {
    public String solution(String s) {
        // s = "  tRy hello  WORLD    ww";
        String answer = "";
        boolean start = true;
        boolean even = true;
        for(int i=0;i<s.length();i++){
            String x = ""+s.charAt(i);
            if(x.equals(" ")){
                answer +=" ";
                start = true;
                even = true;
            }else{
                if(start){
                    answer += x.toUpperCase();
                    start = false;
                    even = false;
                }else{
                    if(even)
                      answer +=x.toUpperCase();
                     else
                       answer +=x.toLowerCase();
                     even = !even;
                }
            }
        }
        return answer;
    }
}