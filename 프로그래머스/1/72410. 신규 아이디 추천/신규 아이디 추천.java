class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        //1단계
        new_id = new_id.toLowerCase();
        //2단계
        for(int i=0;i<new_id.length();i++){
            char c = new_id.charAt(i);
            if(('a'<=c&&c<='z')||('0'<=c&&c<='9')||c=='-'||c=='_'||c=='.'){
                sb.append(c);
            }
        }
        answer = sb.toString();
        // System.out.println(answer);
        // 3단계
        while(answer.contains(".."))
              answer= answer.replace("..",".");
        
        // 4단계
        while(answer.length()>0 && answer.charAt(0)=='.'){
            answer = answer.substring(1,answer.length());
        }
        while(answer.length()>0 && answer.charAt(answer.length()-1)=='.'){
            answer = answer.substring(0,answer.length()-1);
        }
         //5단계
        if(answer.length()==0) answer = "a";
       
        //6단계
        if(answer.length()>15) answer= answer.substring(0,15);
        while(answer.length()>0 && answer.charAt(answer.length()-1)=='.'){
            answer = answer.substring(0,answer.length()-1);
        }
        //7단계
        if(answer.length()<3) {
            while(answer.length()<3){
                answer += answer.charAt(answer.length()-1);
            }
        }
        
        return answer;
    }
}