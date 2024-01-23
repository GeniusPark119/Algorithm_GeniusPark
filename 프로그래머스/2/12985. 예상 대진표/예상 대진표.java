// 11시 8분

class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        
        while(true){
            if(min + 1 == max && min%2!=0)
                break;
            
            min = next(min);
            max = next(max);
            answer++;
            
        }

        return answer;
    }
    public int next(int num){ // 이긴 번호의 다음 번호
        if(num%2==0) 
            return num/2;
        else 
            return (num+1)/2;
    }
}