import java.io.*;
import java.util.*;

public class BOJ_13164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 원생의 수 (입력)
		int K = Integer.parseInt(st.nextToken());	// 조의 개수 (입력)
		int[] height = new int[N];					// 원생들의 키 (입력)
		int[] diff = new int[N];					// 인접한 원생들의 키 차이
		
		st = new StringTokenizer(br.readLine());
		height[0] = Integer.parseInt(st.nextToken());
		for(int i=1;i<N;i++) {
			height[i] = Integer.parseInt(st.nextToken());
			diff[i] = height[i] - height[i-1];
		}
		
		Arrays.sort(diff);	// 키 차이 정렬 (오름차순)
		
		int ans = height[N-1]-height[0];	// 키가 가장 큰 원생과 키가 가장 작은 원생의 키 차이
		for(int i=0;i<K-1;i++) {
			ans -= diff[N-i-1];			// 큰 키 차이부터 차례로 (K-1)번 빼기
		}
		
		System.out.println(ans);
	}
}
