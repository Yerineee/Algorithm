import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Double> queue = new LinkedList<>();   // 앞의 기능부터 차례로 배포해야 하므로 큐 이용
        
        // 작업을 하는 데 며칠 걸리는지 계산 후 큐에 저장
        for(int i=0;i<progresses.length;i++) {
            double days = Math.ceil((double)(100-progresses[i])/(double)speeds[i]);
            queue.add(days);
        }
        
        double temp = queue.poll(); // 앞의 기능이 배포되는 데 며칠 걸리는지 저장
        int cnt = 1;                // 배포할 때 몇 개의 기능이 배포되는지 세기
        while(!queue.isEmpty()) {
            // 앞의 기능 배포되기 전에 기능이 완성되지 않으면, 앞의 기능 먼저 배포
            if(temp < queue.peek()) {
                answer.add(cnt);
                temp = queue.poll();
                cnt = 1;
            }
            // 뒤의 기능이 먼저 완성된다면, 앞의 기능과 함께 배포
            else {
                queue.poll();
                cnt++;
            }
        }
        answer.add(cnt);
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
