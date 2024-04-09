import java.io.*;
import java.util.*;

public class BOJ_1835 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 카드의 개수 N
		Deque<int[]> deque = new ArrayDeque<>();	// 덱
		int[] order = new int[N];		// 카드 번호 저장할 배열
		
		for(int i=0;i<N;i++) {
			int[] a = {i,0};	// {현재 카드 순서, 카드 번호}를 덱에 저장
			deque.add(a);
		}
		
		int[] first;	// 맨 앞에 있는 카드
		for(int i=0;i<N;i++) {
			// i번 반복해서 첫 번째 카드를 가장 뒤로 옮기기
			for(int j=0;j<=i;j++) {
				first = deque.poll();
				deque.add(first);
			}
			
			first = deque.poll();	// i번 반복 후 맨 앞에 있는 카드 번호는 i임
			order[first[0]] = i+1;	// 카드 번호 저장하기
		}
		
		// 카드 번호 출력
		for(int i=0;i<N;i++) {
			System.out.print(order[i]+" ");
		}
	}
}
