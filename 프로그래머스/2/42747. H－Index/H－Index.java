class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int max = -1;
        for(int x : citations){
            max = Math.max(max,x);
        }
        for(int i=max;i>=0;i--){
            int cnt = 0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>= i){
                    cnt++;
            }
        }
            // System.out.println("i "+i+"cnt "+cnt);
            
        if(cnt>=i) {
            answer=i;
            break;
        }      
    }
        // if(answer==0) answer = citations.length;
        return answer;
    }
}