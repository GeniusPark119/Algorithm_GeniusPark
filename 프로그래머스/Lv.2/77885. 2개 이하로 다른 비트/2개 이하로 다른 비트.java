// 주어진 10진수 A를 비트로 전환한다. Long.toString(num,2) => 10진수를 2진법으로 string으로 나타냄
// 비트를 10진수로 전환한다. Long.parseLong(bit,2) => 2진수를 10진수로 Long으로 나타냄

// 비트로 전환했을때 1~2개 다른수들중 제일 작은 수를 찾으려면 규칙을 찾아야한다.
// 제일 오른쪽에 있는 0을 찾아야한다. str.lastIndexOf("0")
// 제일 오른쪽에 있는 0을 1로 바꾸고 그다음 1을 0으로 바꾸는것이 제일 기본적인 방법이다.
// 하지만 이때 제일 오른쪽에 있는 0이 마지막위치라면? 그 수만 1로 바꿔주면 된다.
// 하지만 이를 더 쉽게 생각하는 방법이 있다. 이 경우는 주어진 A가 짝수라는 뜻이다. 짝수는 무조건 +1가 답이다.
// 마지막으로 모든 수가 1일 경우의 수이다. 모든수가 1이라면 제일 앞에 10을 넣고 그다음부터 이전 bit를 더해준다.
// 이 때 111이라면 101이 되어야하므로 bit자리수 1개를 뺀다.

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            String bin = Long.toString(numbers[i],2);
            int idx = bin.lastIndexOf("0");
            
            StringBuilder sb = new StringBuilder();
            if(idx==-1){
                sb.append("10");
                sb.append(bin.substring(1,bin.length()));
            }else if(idx == bin.length()-1){    
                sb.append(bin.substring(0,idx));
                sb.append("1");
            }else{
                sb.append(bin.substring(0,idx));
                sb.append("10");
                sb.append(bin.substring(idx+2,bin.length()));
            }
            answer[i] = Long.parseLong(sb.toString(),2);
        }
        return answer;
    }
}