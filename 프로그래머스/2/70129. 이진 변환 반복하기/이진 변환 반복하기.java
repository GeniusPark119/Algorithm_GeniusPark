class Solution {
    public int[] solution(String s) {
        
        int cnt = 0;//지워진 0개수
        int dep = 0;//변환 횟수
        
        while(!s.equals("1")){//1이 되기전까지 반복
            dep++;//변환횟수 +1
            for(int i=0;i<s.length();i++){ // 지워지는 0개수 더하기
                if(s.charAt(i)=='0') cnt++;
            }
            s= s.replaceAll("0",""); // 0 지우기
            int c = s.length(); // 지운숫자의 길이
            s = Integer.toBinaryString(c); // 길이를 이진법으로 나타냄
        }
        
        int[] answer = new int[2];
        answer[0] = dep;
        answer[1] = cnt;
        
        return answer;
    }
}