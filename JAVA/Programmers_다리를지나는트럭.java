import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        
        Queue<Integer> queue = new LinkedList<>(); // 현재 다리 위에 있는 트럭 (다리 빠져나오는 시간을 저장)
        
        queue.offer(answer+bridge_length); // 첫번째 트럭이 다리를 지나는 시간
        int sum = truck_weights[0];     // 현재 다리에 올라간 트럭 무게의 합
        int idx = 0;                    // 다리에 올라간 트럭 중 가장 앞 순서 트럭
        
        while(true) {
        	// 마지막 트럭까지 다리를 모두 건넌 경우
            if(idx >= truck_weights.length && queue.isEmpty()) {
                break;
            }
        	
            answer++;
            
            // 다리 위에 있는 트럭 중 맨 앞 트럭이 다리를 지났으면, 큐에서 꺼내기
            if(!queue.isEmpty() && queue.peek() == answer) {
                queue.poll();
                sum -= truck_weights[idx++];
            }
            
            // 대기하는 트럭이 있고, 현재 다리 위 트럭들과 대기 트럭 무게의 합이 weight보다 작거나 같다면, 대기 트럭을 큐에 넣기
            int next = idx+queue.size();
            if(next < truck_weights.length) {
                if(sum+truck_weights[next] <= weight) {
                    queue.offer(answer+bridge_length);
                    sum += truck_weights[next];   
                }
            }
        }
        
        return answer;
    }
}
