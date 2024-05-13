import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<operations.length;i++) {
            // 명령어가 "I"로 시작하면, 큐에 숫자 삽입
            if(operations[i].startsWith("I")) {
                minHeap.add(Integer.parseInt(operations[i].substring(2)));
                maxHeap.add(Integer.parseInt(operations[i].substring(2)));
            } else {
                // 명령어가 "D 1"로 시작하면, 최댓값 삭제
                if(!maxHeap.isEmpty() && operations[i].startsWith("D 1")) {
                    minHeap.remove(maxHeap.poll());
                }
                // 명령어가 "D -1"로 시작하면, 최솟값 삭제
                if(!minHeap.isEmpty() && operations[i].startsWith("D -1")) {
                     maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        // 큐가 비어있지 않으면 [최댓값, 최솟값]을 반환
        if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            return new int[]{maxHeap.poll(), minHeap.poll()};
        }
        
        return new int[]{0, 0};
    }
}
