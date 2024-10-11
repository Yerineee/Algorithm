import java.util.*;
import java.io.*;

public class BOJ_11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트케이스 수
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine()); // 날의 수
			int[] stock = new int[n]; // 날 별 주가
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}
			
			long ans = 0; // 최대 이익
			int maxStock = stock[n-1]; // 최대 주가
			// 최대 주가를 뒤에서부터 탐색 (앞에서부터 탐색하게 되면 뒤에 더 큰 주가가 나올 수 있으므로 최대 이익이 될 수 없음)
			for(int i=n-2;i>=0;i--) {
				// 최대 주가 갱신
				if(stock[i] > maxStock) {
					maxStock = stock[i];
					continue;
				}
				
				// 이익 갱신
				ans += maxStock-stock[i];
			}
			
			System.out.println(ans);
		}
	}
}
