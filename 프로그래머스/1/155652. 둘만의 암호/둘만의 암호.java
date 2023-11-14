
class Solution {
    String skip;
    public boolean checkskip(char c){
        for(int i=0;i<skip.length();i++){
            if(skip.charAt(i)==c)
                return true;
        }
        return false;
    }
    public String solution(String s, String skip, int index) {
        this.skip = skip;
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            int tmpidx = 0;
            while(tmpidx<index){
                arr[i] = arr[i]=='z'? 'a':(char)(arr[i]+1);
                tmpidx++;
                while(checkskip(arr[i])){
                    arr[i] = arr[i]=='z'? 'a':(char)(arr[i]+1);
                }
                
            }
            sb.append(arr[i]);
        }
        answer = sb.toString();
        return answer;
    }
}