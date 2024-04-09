import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 로프 개수 (입력)
		int[] ropes = new int[N];
		
		// N개의 로프가 각각 들 수 있는 물체의 중량
		for(int i=0;i<N;i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		// 중량 저장된 배열 정렬
		Arrays.sort(ropes);
		
		int max = 0;	// 들어올릴 수 있는 물체의 최대 중량
		for(int i=0;i<N;i++) {
			int temp = ropes[i] * (N-i);	// (해당 인덱스의 로프가 들 수 있는 중량) * (해당 중량을 들어올릴 수 있는 로프의 수)
			max = Math.max(max, temp);		// 최대 중량 갱신
		}
		
		System.out.println(max);	// 최대 중량 출력
	}
}
