class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char before = '-';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==' ' || ('0'<=c&&c<='9')) {
                sb.append(c);
                before = c;
                continue;
            }else if(before==' '|| before=='-'){
                sb.append((c+"").toUpperCase());
                before = c;
            }else{
                sb.append((c+"").toLowerCase());
                before = c;
            }
        }
        // String[] arr = s.split(" ");
        // for(int i=0;i<arr.length;i++){
        //     sb.append((arr[i].charAt(0)+"").toUpperCase());
        //     if(arr[i].length()>1)sb.append(arr[i].substring(1,arr[i].length()).toLowerCase());
        //     if(i!=arr.length-1)sb.append(" ");
        // }
        answer = sb.toString();
        return answer;
    }
}