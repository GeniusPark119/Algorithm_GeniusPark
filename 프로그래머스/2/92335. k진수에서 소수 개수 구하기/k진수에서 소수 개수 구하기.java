// k 진수로 바꾸는 메서드
// 소수 판별하는 메서드
// 0이 들어가지 않는 수 골라내는 메서드
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] numbers = change(n,k).split("0");
        for(String x : numbers){
            
            if(x.length()==0) continue;
            if(isSosu(Double.valueOf(x))) answer++;
        }
        
        return answer;
    }
    public String change(int num,int k){// k진수로 바꾸는 메서드
        if(k==10) return num+"";
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            sb.append(num%k);
            num/=k;
        }
        return sb.reverse().toString();
    }
    
    public boolean isSosu(Double num){ // 소수판별
        if(num==1) return false;
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
}