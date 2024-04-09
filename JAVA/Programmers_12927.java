import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    // 매개변수 (n: 퇴근까지 남은 시간, works: 각 일에 대한 작업량)
    public long solution(int n, int[] works) {
        long answer = 0;
        
//         // 1. 배열 이용 - 시간 초과
//         // works 배열 정렬 후 가장 큰 작업량 1 감소
//         for(int i=0;i<n;i++) {
//             Arrays.sort(works);
//             works[works.length-1]-=1;
//         }
        
//         // 해당 작업량이 0보다 작거나 같다면 0을 더하고, 그렇지 않다면 작업량의 제곱 값을 더함
//         for(int i=0;i<works.length;i++) {
//             if(works[i]<=0) {
//                 answer+=0;
//             } else {
//                 answer+=works[i]*works[i];
//             }
//         }
        
        // 2. 우선 순위 큐를 이용해 최대 힙 구현
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        // 남은 작업량을 우선 순위 큐에 저장
        for(int i=0;i<works.length;i++) {
            maxHeap.add(works[i]);
        }
        
        // 남은 작업량 중 최댓값을 최대 힙에서 꺼낸 뒤 1만큼 감소 (최댓값이 0인 경우 더 이상 감소시킬 필요 없으므로 반복문 종료)
        for(int i=0;i<n;i++) {
            int maxNum = maxHeap.poll();
            if(maxNum==0) break;
            maxHeap.add(--maxNum);
        }
        
        // 최대 힙에서 작업량 꺼낸 뒤 작업량의 제곱 값을 더함 (최대 힙에서 꺼낸 작업량이 0보다 작거나 같은 경우 더이상 최대 힙에 저장된 값을 꺼내볼 필요가 없으므로 종료)
        while(!maxHeap.isEmpty()) {
            int temp = maxHeap.poll();
            if(temp<=0) break;
            answer += temp*temp;
        }
        
        return answer;
    }
}
