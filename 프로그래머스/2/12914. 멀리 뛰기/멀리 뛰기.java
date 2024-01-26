class Solution { // 24/1/26 11 : 40
    public int[] pivos;
    public long solution(int n) {
        long answer = 0;
        pivos = new int[2001];
        pivos[0] = 0;
        pivos[1] = 1;
        pivos[2] = 2;
        // 1칸 -> 1
        // 2칸 -> 2
        // 3칸 -> 3
        // 4칸 -> 5
        answer = pivo(n);
        return answer;
    }
    public int pivo(int i){
        if(i==0) return 0;
        if(i==1) return 1;
        if(i==2) return 2;
        if(pivos[i]==0)
            pivos[i] = (pivo(i-2)+pivo(i-1))%1234567;
        
        return pivos[i];
    }
}