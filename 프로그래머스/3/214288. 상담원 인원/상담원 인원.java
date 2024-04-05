import java.util.*;

// k : 상담 유형
// n : 멘토 몇명

// [시작분,걸리는분,유형번호]

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        
        // 유형별로 타임라인을 저장하는 list
        // idx 숫자가 유형 <-- [시작시간,끝나는시간]
        List<List<Timeline>> timelineEachType = new ArrayList<>();

        for (int i = 0; i <= k; i++) { // list에 k개의 유형 만큼 1부터 idx를 만들어준다.
            timelineEachType.add(new ArrayList<>());
        }

        for (int[] req : reqs) { // 유형별로 타임라인을 따로 저장한다.
            int start = req[0];
            int duration = req[1];
            int type = req[2];

            // 해당 유형에 timeline 저장
            timelineEachType.get(type).add(new Timeline(start, start + duration)); // 시작과 끝을 각 유형별로 추가해준다.
        }

        // 각 유형에 1부터 최대 ( 멘토수 (n) - 나빼고 유형수 (k-1)) 상담수를 배치하고 상담자 수에 따른 대기 시간 저장

        int[][] waitingEachType = new int[k + 1][n + 1]; // 유형별 상담원수에 따른 기다림 사람수

        for (int type = 1; type <= k; type++) { // 유형 별
            // 해당 유형에 상담을 신청한 지원자가 없을때
            if (timelineEachType.get(type).isEmpty()) continue; // 해당유형을 원하는 멘토가 없으면 건너뛰기

            // 해당 유형에 몇명의 상담원을 배정할지 최소값부터 최대값까지
            for (int consultant = 1; consultant <= (n - k) + 1; consultant++) {
                // 유형별 idx에서 시작-끝이 저장되어있는 타임라인을 꺼내 calTime을 통해 기다림 시간 측정
                int waiting = calTime(timelineEachType.get(type), consultant);
                // 해당 유형에 현재 상담원 인원으로 상담했을때 기다림수를 저장한다.
                waitingEachType[type][consultant] = waiting;
            }

        }

        // 우선 각 상담원을 한명씩 배치하고 남은 상담수를 구한다. 기다림시간이 많이 줄어드는 곳에 차근차근 상담원 배치
        int[] currCsult = new int[k + 1];
        Arrays.fill(currCsult, 1);

        int remain = n - k; // 상담원 1씩 배치 후 남은 상담원

        while (remain-- > 0) { // 그리디

            int max = 0; // 1 늘었을때 가장 대기시간 많이 줄어드는 시간
            int maxType = 0; // 그 유형 번호

            for (int type = 1; type <= k; type++) {
                // 현재 상담원 수
                int curr = currCsult[type];
                // 현재 상담원 수에서의 기다림 시간
                int wait = waitingEachType[type][curr];
                // 상담원이 1 늘었을때 기다림 시간
                int next = waitingEachType[type][curr + 1];
                // 상담원이 추가되었을 때 줄어드는 대기시간
                int reduce = Math.abs(wait - next); // 왜 abs일까?

                // 상담원 추가되었을때 가장 많이 줄어드는 시간과 유형 저장
                if (reduce >= max) { // 왜 초과가 아닐까?
                    max = reduce;
                    maxType = type;
                }
            }

            // 상담원 증겨시켜도 더이상 줄어들 대기시간 없을때
            if (max == 0) break;

            // 가장 긴 대기시간을 가진 것에 상담원 추가
            currCsult[maxType]++;
        } // 그리디 끝

        int answer = 0;

        //5. 상담원 배치가 끝나고 계산
        for (int type = 1; type <= k; type++) {

            // 타임 라인이 없으면 패스
            if (timelineEachType.get(type).isEmpty()) continue;

            // 정해진 상담원 수 불러오기
            int consultant = currCsult[type];

            // 답에 더한다 각 타입의 최상의 기다림 시간을
            answer+=waitingEachType[type][consultant];

        }
        return answer;

    } // main 끝

    static int calTime(List<Timeline> timelines, int consultant) { // 상담원 수 몇명 배치?
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선 순위 큐
        int waiting = 0; // 기다린 시간

        for (Timeline t : timelines) { //
            if (pq.isEmpty() || pq.size() < consultant) {
                pq.offer(t.end);
            } else {
                int firstEnd = pq.poll();

                if (t.start < firstEnd) {
                    waiting += firstEnd - t.start;
                    pq.offer(firstEnd + (t.end - t.start));

                } else {
                    pq.add(t.end);
                }
            }
        }
        return waiting;
    }

    static class Timeline {
        int start, end;

        Timeline(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    }
