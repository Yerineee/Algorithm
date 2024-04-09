import java.io.*;
import java.util.*;

public class BOJ_1374 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 강의 개수
		PriorityQueue <int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			// 시작 시간 기준으로 오름차순 정렬하기 (같다면 종료 시간 기준으로 정렬)
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[2]-o2[2];
				else
					return o1[1]-o2[1];
			}
		});
		
		int num, start, end;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());		// 강의 번호
			start = Integer.parseInt(st.nextToken());	// 시작 시간
			end = Integer.parseInt(st.nextToken());		// 종료 시간
			
			queue.add(new int[] {num, start, end});		// 큐에 강의 정보 저장
		}
		
		PriorityQueue <Integer> temp = new PriorityQueue<>();	// 강의 끝나는 시간 저장 (강의실마다)
		int[] a;
		temp.add(0);
		while(!queue.isEmpty()) {
			a = queue.poll();
			end = temp.poll();
			// 강의 종료 시간보다 강의 시작 시간이 더 늦거나 같다면
			if(a[1] >= end) {
				temp.add(a[2]);	// 큐에 해당 강의 종료 시간 저장
			}
			// 강의 종료 시간과 강의 시작 시간이 같거나 시작 시간이 더 이르다면
			else {
				temp.add(end);	// 큐에 원래 있던 강의 종료 시간 다시 저장
				temp.add(a[2]);	// 큐에 해당 강의 종료 시간도 저장
			}
		}
		
		System.out.println(temp.size());
	}
}
