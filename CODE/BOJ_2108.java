import java.io.*;
import java.util.*;

public class BOJ_2108 {
	static int N;
	static int[] arr;
	static int max, num, cnt;
	static ArrayList<Integer> list;
	
	public static void compare() {
		if(cnt > max) {
			max = cnt;
			list.clear();
			list.add(num);
		}
		else if(cnt == max && cnt != Integer.MIN_VALUE) {
			list.add(num);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 수의 개수
		arr = new int[N];		// 수 저장할 배열
		
		// N번 반복해서 수를 배열에 저장
		int sum = 0;	// 수의 합 저장할 변수
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		Arrays.sort(arr);	// 배열 정렬
		
		max = num = cnt = Integer.MIN_VALUE;
		list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			compare();
			
			// 이전 인덱스의 수와 다른 경우
			if(num != arr[i]) {
				cnt = 1;
				num = arr[i];
			}
			// 이전 인덱스의 수와 같은 경우
			else {
				cnt++;
			}
		}
		compare();
		
		System.out.println(Math.round((double)sum/N));	// 산술평균 출력
		System.out.println(arr[(N-1)/2]);		// 중앙값 출력
		// 최빈값 출력
		if(list.size() > 1) {
			System.out.println(list.get(1));
		}
		else if(list.size() == 1) {
			System.out.println(list.get(0));
		}
		System.out.println(arr[N-1]-arr[0]);	// 범위 출력
	}
}
