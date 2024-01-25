class Solution {
    public int[] pivos;
    public int solution(int n) {
        int answer = 0;
        pivos = new int[100001];
        pivos[0] = 0;
        pivos[1] = 1;
        
        answer = pivo(n);
        return answer;
    }
    public int pivo(int num){
        if(num==0) return 0;
        if(pivos[num]!=0) return pivos[num];
        pivos[num] = (pivo(num-1)+ pivo(num-2))%1234567;

        return pivos[num];
        
    }
}