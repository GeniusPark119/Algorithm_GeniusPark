// 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.

// fee 배열 :  기본시간(분) / 기본요금 / 단위시간(분) / 단위요금
// records 배열  :   00:00  /  차량번호4자리  / IN or OUT 


// 1. 차량별 누적시간을 구해야한다. -> 00:00 끼리 몇분텀인지 계산해야함, 출차없는 차량에 12:59 반영해야함
// 2. 주차요금을 구해야한다. 기본요금으로 끝나는지 ? 아니면 +  누적/단위시간의 올림 * 단위요금 
// 3. 차량번호의 오름차순대로 차량요금을 정렬한다.

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        getTime("01:01","02:02");
        return answer;
    }
    public int getTime(String start,String end){
        String[] time1 = start.split(":");
        String[] time2 = end.split(":");
        System.out.println(Integer.valueOf(time1[0]));
        return 3;
    }
}