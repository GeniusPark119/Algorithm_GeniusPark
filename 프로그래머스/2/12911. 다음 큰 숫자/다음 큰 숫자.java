class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        String binN = Integer.toString(n,2);
        for(int i=0;i<binN.length();i++){
            if(binN.charAt(i)=='1') cnt++;
        }
        // System.out.println(binN);
        while(true){
            n++;
            int tmpCnt = 0;
            String tmpN = Integer.toString(n,2);
            for(int i=0;i<tmpN.length();i++){
                if(tmpN.charAt(i)=='1') tmpCnt++;
            }
            if(cnt==tmpCnt) return n;
        }
    }
}