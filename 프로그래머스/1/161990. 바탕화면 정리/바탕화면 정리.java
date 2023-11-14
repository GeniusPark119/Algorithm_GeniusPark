class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int minx = 51;
        int maxx = -1;
        int miny = 51;
        int maxy = -1;
        //[miny][minx] ~ [maxy][maxx]
        
        for(int i=0;i<wallpaper.length;i++){
            for(int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minx = Math.min(minx,i);
                    maxx = Math.max(maxx,i);
                    miny = Math.min(miny,j);
                    maxy = Math.max(maxy,j);
                }
            }
        }
        answer = new int[]{minx,miny,maxx+1,maxy+1};
        return answer;
    }
}