// 일단 주어진 plans 배열을 시작시간 순으로 정렬해야한다.

// 시간 순서대로 진행될 과제객체(과목,주어진 시간,남은 시간)들을 queue에 순서대로 넣는다.

// 0 일때 과목[0] 을 주어진시간[0] 동안 
// 1) 다 끝내면 만약 멈춘과제 stack가 있다면 그걸 진행, 없다면 다음 과목[1]과 주어진시간[1]로 넘어감
// 2) 만약에 과목[0]을 다 끝내지 못했다면 멈춘과제 stack에 저장한다.

// 잠시 멈춘 과제를 stack 에 저장한다. 최근 순서대로 이어서 과제를 진행해야하기 때문이다.
// 잠시 멈춘 과제별 남은 시간은 어떻게 저장해야할까. Homework 객체를 만들어서 저장하자.

// 그렇다면 과제가 완료되었다는 시그널은 어디서 확인해야할까? 
// 다음 과제가 시작할 시간이 되었을때 그 과제로 포커싱을 어떻게 해야할까?
// 머터 : 머리터져

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    class Homework{ // 과목 이름과, 주어진 시간,남은 소요시간
        String name;
        int term;
        int remain;
        
        public Homework(String name,int term,int remain){
            this.name = name;
            this.term = term;
            this.remain = remain;
        }
    }// end class Homework
    public Queue<Homework> hw_queue = new LinkedList<>(); // 과제 진행 순서
    public Stack<Homework> stop_stack = new Stack<>(); // 멈춘 과제
    String[] answer;
    int idx;
    public String[] solution(String[][] plans) {
        answer = new String[plans.length];
        // 시작순서대로 나열한다
        Arrays.sort(plans,(a,b)->(timeToInt(a[1])-timeToInt(b[1]))); 
        // 시작 순서대로 Homework 객체를 hw_queue에 넣는다.
        for(int i=0;i<plans.length;i++){ 
            if(i==plans.length-1){
                hw_queue.offer(
                new Homework(plans[i][0],Integer.valueOf(plans[i][2])
                             ,Integer.valueOf(plans[i][2]))
            );
                continue;
            }
            hw_queue.offer(
                new Homework(plans[i][0],hw_term(plans[i][1],plans[i+1][1])
                             ,Integer.valueOf(plans[i][2]))
            );
        }// end for문
        
        end_names();
        
        return answer;
    }
    public void end_names(){
        while(!hw_queue.isEmpty()){
            Homework hw = hw_queue.poll();
            // 주어진 시간 - 소요시간 

            int tmp_term = hw.term - hw.remain;
            // tmp_term 이 음수이면 해당 과목을 중단해야하므로 stack에 남은 시간과 함께 저장한다.
            if(tmp_term<0) {
                stop_stack.push(new Homework(hw.name,0,tmp_term*(-1)));
            }else{
                //하지만 양수라면 answer 배열에 추가하고
                answer[idx++] = hw.name;
                //시간도 남고 중단한 과목이 있다면 
                if(tmp_term>0 && !stop_stack.isEmpty()){
                    while(!stop_stack.isEmpty() && tmp_term!=0){
                        Homework stop_hw = stop_stack.pop();
                        tmp_term -= stop_hw.remain;
                        if(tmp_term>=0)
                            answer[idx++] = stop_hw.name;
                        else {
                            stop_stack.push(new Homework(stop_hw.name,0,tmp_term*(-1)));
                            break;
                        }
                    }
                }
            }
                  
        }
        
        while(!stop_stack.isEmpty()) answer[idx++] = stop_stack.pop().name;
    }
    public int timeToInt(String time){
        return Integer.valueOf(time.substring(0,2)+time.substring(3,5));
    }
    public int hw_term(String start,String end){
        int start_h = Integer.valueOf(start.substring(0,2));
        int start_m = Integer.valueOf(start.substring(3,5));
        int end_h = Integer.valueOf(end.substring(0,2));
        int end_m = Integer.valueOf(end.substring(3,5));
        
        return (end_h - start_h) * 60 + (end_m - start_m);
    }
}