// 철수 카드와 영희 카드 중 최소값이 더 큰 수

// 철수 카드에서 나누어 떨어지는 수를 영희에서 나누어 떨어지지 않는지 확인한다.
// 철수의 공약수와 영희의 공약수를 비교한다. 둘 중 하나는 있고 없는 최대값의 약수를 구한다.

// 공약수를 구하는 메서드가 필요하다.

import java.util.List;
import java.util.ArrayList;

class Solution {
    List<Integer> list = new ArrayList<>();
    int answer=0;
    public int solution(int[] arrayA, int[] arrayB) {
        getA(arrayA,arrayB);
        
        return answer;
    }
    public void getA(int[] arrayA,int[] arrayB){
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int x : arrayA){
            gcdA = gcd(x,gcdA);
        }
        for(int x : arrayB){
            gcdB = gcd(x,gcdB);
        }
        
        if(!isDived(arrayA,gcdB)){
            answer = Math.max(answer,gcdB);
        }
        if(!isDived(arrayB,gcdA)){
            answer = Math.max(answer,gcdA);
        }
            
    }
    public int gcd(int a,int b){
        if(b==0) return a;
            
        return gcd(b,a%b);
    }
    public boolean isDived(int[] arr,int num){
        for(int a : arr){
            if(a%num==0) return true;
        }
        return false;
    }
}