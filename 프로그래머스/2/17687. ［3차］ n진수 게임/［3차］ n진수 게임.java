
class Solution {
    StringBuilder sb = new StringBuilder();
    StringBuilder sb_whole = new StringBuilder();
    int num=0;
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        while(sb_whole.length()<m*t){
            sb_whole.append(change(num,n));
            num++;
        }
        String str = sb_whole.toString();
        for(int i=0;i<t;i++){
            answer += str.charAt(m*i+p-1);
        }
        return answer.toUpperCase();
    }
    
    public String change(int num,int n){ // num 을 n진수로 바꾸는 메서드
        if(num == 0) return "0";
        else if(n==10) return ""+num;
        
        sb.setLength(0);
        
        if(n>10){ // 11진수에서 16진수
            while(num!=0){
                if(num%n >9){
                    sb.append((char)(num%n+55));
                }else{
                    sb.append(num%n);
                }
                num/=n;
            }
            return sb.reverse().toString();
        }else{ // 2진수~ 9진수
            while(num!=0){
                sb.append(num%n);
                num/=n;
            }
            return sb.reverse().toString();
        }
    }
}