class Solution {
    public int[] two ={3,1,0,1,2,1,2,3,2,3,4}; // 2까지 각 index 숫자로부터의 거리 10번은 *#
    public int[] five ={2,2,1,2,1,0,1,2,1,2,3}; // 5까지 각 index 숫자로부터의 거리 10번은 *#
    public int[] eight ={1,3,2,3,2,1,2,1,0,1,2}; // 8까지 각 index 숫자로부터의 거리 10번은 *#
    public int[] zero ={0,4,3,4,3,2,3,2,1,2,1}; // 0까지 각 index 숫자로부터의 거리 10번은 *#
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean right = true;
        if(hand.equals("left")) right = false;
        int nowR = 10;//#
        int nowL = 10;//*
        for(int x : numbers){
            if(x==1||x==4||x==7){
                nowL = x;
                sb.append("L");
            }
            else if(x==3||x==6||x==9){
                nowR = x;
                sb.append("R");
            }else{
                if(x==2){
                    if(two[nowL]>two[nowR]){
                        nowR = x;
                        sb.append("R");
                    }else if(two[nowL]<two[nowR]){
                        nowL = x;
                        sb.append("L");
                    }else{
                        if(right){
                            nowR = x;
                            sb.append("R");
                        }else{
                            nowL = x;
                            sb.append("L");
                        }
                    }
                }if(x==5){
                    if(five[nowL]>five[nowR]){
                        nowR = x;
                        sb.append("R");
                    }else if(five[nowL]<five[nowR]){
                        nowL = x;
                        sb.append("L");
                    }else{
                        if(right){
                            nowR = x;
                            sb.append("R");
                        }else{
                            nowL = x;
                            sb.append("L");
                        }
                    }
                }if(x==8){
                    if(eight[nowL]>eight[nowR]){
                        nowR = x;
                        sb.append("R");
                    }else if(eight[nowL]<eight[nowR]){
                        nowL = x;
                        sb.append("L");
                    }else{
                        if(right){
                            nowR = x;
                            sb.append("R");
                        }else{
                            nowL = x;
                            sb.append("L");
                        }
                    }
                }if(x==0){
                    if(zero[nowL]>zero[nowR]){
                        nowR = x;
                        sb.append("R");
                    }else if(zero[nowL]<zero[nowR]){
                        nowL = x;
                        sb.append("L");
                    }else{
                        if(right){
                            nowR = x;
                            sb.append("R");
                        }else{
                            nowL = x;
                            sb.append("L");
                        }
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}