// 1. 우선순위 큐 이용 (풀이 참고)
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 우선순위 큰 값부터 꺼냄
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int priority : priorities) {
            queue.add(priority);
        }
        
        // 우선순위 큐에서 값을 꺼내가며 비교
        while(!queue.isEmpty()) {
            for(int i=0;i<priorities.length;i++) {
                // 현재 가장 높은 우선순위와 i번째 위치의 우선순위가 같다면, 프로세스 꺼내기
                if(queue.peek() == priorities[i]) {
                    queue.poll();
                    answer++;

                    // 구하고자 하는 location과 현재 인덱스가 같다면, answer 반환
                    if(i == location) {
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}

// 2. Queue와 ArrayList 이용 (기존에 푼 방법)
/*
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 가장 높은 우선순위 구하기
        ArrayList<Integer> priority = new ArrayList<>();
        for(int i=0;i<priorities.length;i++) {
            priority.add(priorities[i]);
        }
        int max = Collections.max(priority);
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;i++) {
            // [위치, 우선순위] 배열을 큐에 저장
            queue.add(new int[]{i, priorities[i]});
        }
        
        while(true) {
            int[] cur = queue.poll();
            // 알고싶은 프로세스이고, 대기 큐에서 우선순위가 제일 높다면 반복문 끝내기
            if(cur[0]==location && cur[1]==max) break;
            
            // 꺼낸 프로세스의 우선순위가 제일 높다면, 프로세스 다시 안 넣지 않고 max 갱신
            if(cur[1] == max) {
                answer++;
                priority.remove(priority.indexOf(max));
                max = Collections.max(priority);
            } else {
                queue.add(cur);
            }
        }
        
        return answer+1;
    }
}
*/
