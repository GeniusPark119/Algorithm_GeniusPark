// 10A 11B 12C 13D 14E 15F
// 2~10진법으로 바꿔주는 메서드
// 11~16진법으로 바꿔주는 메서드

// 진법 n
// 참가 인원 m
// 튜브의 순서 p
// 숫자 개수 t

class Solution {
    StringBuilder sb = new StringBuilder();
    StringBuilder sb_whole = new StringBuilder();
    int num = 0;
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        while(sb_whole.length()<m*t){
            sb_whole.append(change(num,n));
            // sb_whole.append(" ");
            num++;
        }
        String str = sb_whole.toString();
        // System.out.println(str);
        for(int i=0;i<t;i++){
            answer += str.charAt(m*i+p-1);
        }
        return answer.toUpperCase();
    }
    public String change(int num,int n){
        // if(num==0) return "0"; // 숫자가 0일 때
        // else if(n==10) return ""+ num;// 10진수일 때
        
        // sb.setLength(0); // 여기서부터는 sb를 사용하니 sb 초기화
        
        return Integer.toString(num,n);
//         if(n>10){ // 11진수~16진수
//             while(num!=0){
//                 if(num%n>9){
//                     sb.append((char)(num%n+55));
//                 }else{
//                     sb.append(num%n);
//                 }
//                 num/=n;
//             }
//             return sb.reverse().toString(); 
            
//         } else {// 2진수 ~ 9진수
//             while(num!=0){
//                 sb.append(num%n);
//                 num/=n;
//             }
//             return sb.reverse().toString();
//         }
    }
}