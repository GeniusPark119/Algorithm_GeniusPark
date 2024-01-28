class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] numbers = Integer.toString(n,k).split("0");
        System.out.println(Integer.toString(n,k));
        
        for(String x : numbers){
            if(x.length()==0) continue;
            if(isSosu(Double.valueOf(x))) answer++;
        }
        return answer;
    }
    // public String change(int num,int k)
    
    public boolean isSosu(Double num){
        if(num==1) return false;
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        System.out.println(num);
        return true;
    }
        
}