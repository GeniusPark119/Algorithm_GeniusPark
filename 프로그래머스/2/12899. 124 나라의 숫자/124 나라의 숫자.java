// 1 % 3 = 1 ->1
// 2 % 3 = 2 ->2
// 3 % 3 = 0 ->4
// {4,1,2}

class Solution {
  public String solution(int n) {
      
      String[] numbers = {"4","1","2"};
      String answer ="";
      StringBuilder sb = new StringBuilder();
      
      int num = n;
      
      while(num>0){
          int remainder = num%3;
          num /= 3;
          if(remainder==0) num--;
          
          sb.append(numbers[remainder]);
      }
      
      return sb.reverse().toString();

  }
}