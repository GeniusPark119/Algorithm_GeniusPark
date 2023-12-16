//231216 16시 24분 ~ 16시 50분 (26분)

class Solution{
    
    public boolean isMeet(int a,int b){// 둘중하나가 홀수 , 짝수 일때 홀수+1 이 짝수가 되면 붙게된것
        if(a%2==1 && b%2==0 && a+1 == b) return true; 
        else if(a%2==0 && b%2 ==1 && b+1 == a ) return true;
        return false;
    }// 둘이 붙게된것인지 true false로 반환
    
    public int nextNum(int x) { // 해당 번호가 이기면 다음 번호가 어떻게 되는지 반환
        if(x%2==0) return x/2;
        else return (x+1)/2;
    }
    
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(true){
            answer++;
            if(isMeet(a,b)) break;
            a = nextNum(a);
            b = nextNum(b);
        }
            
        return answer;
    }
}