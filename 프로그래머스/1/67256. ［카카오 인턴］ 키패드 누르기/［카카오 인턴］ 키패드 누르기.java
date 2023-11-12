class Solution {
    //0부터 9까지 좌표
    int[][] numpadPos = {
        {3,1},
        {0,0},{0,1},{0,2},
        {1,0},{1,1},{1,2},
        {2,0},{2,1},{2,2}
    };
    int[] leftPos = {3,0};
    int[] rightPos = {3,2};
    String hand;
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        this.hand = hand.equals("left")? "L" : "R";
        
        for(int num : numbers){
            String Umjii = pushNumber(num);
            sb.append(Umjii);
            if(Umjii.equals("L")) leftPos = numpadPos[num];
            else rightPos = numpadPos[num];
        }
        answer = sb.toString();
        return answer;
    }
    private String pushNumber(int num){
        if(num==1||num==4||num==7){
            return "L";
        }
        if(num==3||num==6||num==9){
            return "R";
        }
        if(getDist(leftPos,num)<getDist(rightPos,num)) return "L";
        if(getDist(leftPos,num)>getDist(rightPos,num)) return "R";
        
        return hand;
    }
    private int getDist(int[] pos,int num){
        return Math.abs(pos[0]-numpadPos[num][0])+Math.abs(pos[1]-numpadPos[num][1]);
    }
}