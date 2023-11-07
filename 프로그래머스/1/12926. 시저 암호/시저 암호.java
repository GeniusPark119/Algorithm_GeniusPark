class Solution {
    public char next(char c){
        if('a'<= c && c < 'z') return (char)(c+1);
        else if(c=='z') return (char)(c-25);
        else if('A'<= c && c<'Z') return (char)(c+1);
        else if(c=='Z') return (char)(c-25);
        else return ' ';
    }
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            for(int j=0;j<n;j++)
               c= next(c);
            answer +=c;
        }
        
        return answer;
    }
}