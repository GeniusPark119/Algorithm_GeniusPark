import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNums = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            strNums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNums,(o1,o2)->(o2+o1).compareTo(o1+o2));
        if(strNums[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : strNums){
            sb.append(s);
        }
        answer = sb.toString();
        return answer;
    }
}