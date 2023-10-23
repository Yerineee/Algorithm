import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 최소 힙 이용
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // 모든 음식의 스코빌 지수를 최소 힙에 저장
        for(int i=0;i<scoville.length;i++) {
            minHeap.add(scoville[i]);
        }
        
        // 모든 음식의 스코빌 지수가 K보다 작으면 반복 (스코빌 지수의 최솟값이 K보다 작으면 반복)
        while(minHeap.peek() < K) {
            // 최소 힙의 크기가 1 이하이면 스코빌 지수를 K 이상으로 만들 수 없으므로(새로운 음식을 만들 수 없기 때문) answer 변수에 -1 저장
            if(minHeap.size()<=1) {
                answer = -1;
                break;
            }
            
            // 최소 힙의 크기가 1보다 큰 경우에는 새로운 음식을 만든 후 최소 힙에 저장
            int newFood = minHeap.poll() + minHeap.poll()*2;
            minHeap.add(newFood);
            
            // answer 변수(음식을 섞은 횟수) 1 증가
            answer++;
        }
        
        return answer;
    }
}
