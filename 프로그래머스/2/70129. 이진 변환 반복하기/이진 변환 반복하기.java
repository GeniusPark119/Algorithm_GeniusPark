class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int cntZero = 0;
        int cntBinary =0;
        while(!s.equals("1")){
            cntBinary++;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0') cntZero++;
            }
            s = s.replace("0","");
            int len = s.length();
            StringBuilder sb = new StringBuilder();
            while(len!=0){
                sb.append(len%2);
                len /=2;
            }
            s = sb.reverse().toString();
        }
        answer = new int[2];
        answer[0] = cntBinary;
        answer[1] = cntZero;
        return answer;
    }
}