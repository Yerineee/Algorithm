// ArrayList와 LinkedList의 차이 비교 : https://github.com/wjdrbs96/Today-I-Learn/blob/master/Java/Collection/List/ArrayList%20vs%20LinkedList.md 참고하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue =  new LinkedList<>();
		for(int i=2;i<=N;i+=2) {
			queue.add(i);
		}
		
		// 홀수이면, 리스트에 저장된 숫자 2를 맨 뒤로 이동시키기
		if(N%2!=0 && queue.size()>1) {
			queue.remove();
			queue.add(2);
		}
		
		// 리스트에 남아있는 수가 1개가 될 때까지 반복
		while(queue.size()>1) {
			// 제일 위에 있는 카드 버리기
			queue.remove();
			
			// 두 번째 카드를 제일 아래로 옮기기
			queue.add(queue.poll());
		}

		if(N==1) {
			System.out.println(1);
		} else {
			System.out.println(queue.peek());	
		}
	}
}
