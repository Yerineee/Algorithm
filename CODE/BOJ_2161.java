import java.util.*;
import java.io.*;

public class BOJ_2161 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();	// 결과 (버린 카드 순서대로)
		int N = Integer.parseInt(br.readLine());	// 정수 N
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		
		int removedNum, movedNum;	// 버려진 카드, 밑으로 옮겨진 카드 저장할 변수
		for(int i=0;i<N;i++) {
			removedNum = queue.poll();	// 맨위의 카드 버림
			ans.append(removedNum+" ");	// 버린 카드를 StringBuilder에 저장
			
			if(!queue.isEmpty()) {
				movedNum = queue.poll();	// 제일 위에 있는 카드 저장
				queue.add(movedNum);		// 제일 아래로 옮김
			}
		}
		
		System.out.println(ans.toString());
	}
}
