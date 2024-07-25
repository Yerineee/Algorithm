import java.util.*;

class Solution {
    static int answer = 0;
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
    static long sum1, sum2;

    // 주어진 배열의 숫자들을 각각의 큐에 숫자 저장하기, 숫자들의 합 반환
    static long init(int[] arr, int num) {
        long sum = 0;
        
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            if(num == 1) {
                q1.add(arr[i]);
            } else {
                q2.add(arr[i]);
            }
        }
        
        return sum;
    }
    
    public int solution(int[] queue1, int[] queue2) {
        sum1 = init(queue1, 1);  // 큐1 숫자들의 합
        sum2 = init(queue2, 2);  // 큐2 숫자들의 합

      // 각 큐의 숫자들의 합이 다르고 answer이 큐 길이의 3배보다 작으면, 계속 탐색
      // answer이 큐 길이의 3배보다 크거나 같다면, 두 큐의 숫자들의 합이 같아질 수 없는 것임
        while(sum1 != sum2 && answer < queue1.length*3) {
          // 숫자들의 합이 큰 곳에서 작은 쪽으로 숫자 옮기기
            if(sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
            } else {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
            }
            
            answer++;
        }

      // 숫자들의 합이 같아질 수 없다면 -1 반환
        if(answer >= queue1.length*3) return -1;
        
        return answer;
    }
}
