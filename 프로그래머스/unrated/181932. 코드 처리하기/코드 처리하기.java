// import java.util.Stack;

// class Solution {
//     public Stack<Character> stack = new Stack<>();
//     public String solution(String code) {
//         String answer = "";
//         boolean modeZero = true;
//         for(int i=0;i<code.length();i++){
//             char c = code.charAt(i);
//             if(c=='1'){ 
//                 modeZero = !modeZero;
//                 continue;
//             }
//             if(modeZero && i %2==0){
//                 stack.push(c);
            
//             }else if(!modeZero && i%2!=0){
//                 stack.push(c);
//             }
                
                
//             }
//             if(stack.isEmpty()) answer = "EMPTY";
//             else {
//                 while(!stack.isEmpty()){
//                 answer += stack.pop();
//                 }
//                 answer = new StringBuilder(answer).reverse().toString();
//             }
//         return answer;
//     }
// }

import java.util.Stack;

class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int mode = 0;
        for(int i=0;i<code.length();i++){
            char c = code.charAt(i);
            if(c=='1'){ 
                mode = mode==0? 1:0;
                continue;
            }
            if(mode==0 && i %2==0){
                sb.append(c);
            
            }else if(mode==1 && i%2!=0)
                sb.append(c);
                
                
            }
            answer = sb.toString();
            if(answer.length()==0) answer = "EMPTY";
        return answer;
    }
}