import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {
	static int N;			// 지방의 수 N
	static int[] request;	// N개 지방의 예산요청
	
	// 상한액을 기준으로 예산 총액 계산하여 반환하는 함수 (매개변수 high는 상한액)
	public static int budgetTotal(int high) {
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += Math.min(request[i], high);
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	// 지방의 수 N
		request = new int[N];	// N개 지방의 예산요청
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			request[i] = Integer.parseInt(st.nextToken());
		}
		
		// 지방의 예산요청 저장된 배열 오름차순으로 정렬
		Arrays.sort(request);
		
		int M = Integer.parseInt(br.readLine());	// 국가예산 총액 M
		
		// 이분탐색 이용
		int low=1, high=request[N-1];
		// 예산 요청의 총합이 국가예산의 총액보다 클 경우 이분탐색 진행
		if(budgetTotal(request[N-1])>M) {
			while(low<=high) {
				int mid = (low+high)/2;
				
				if(budgetTotal(mid)>M) {
					high = mid-1;
				} else {
					low = mid+1;
				}
			}
		}
		
		System.out.println(high);
	}
}
