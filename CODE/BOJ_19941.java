import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_19941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);	// 식탁 길이 n
		int k = Integer.parseInt(input[1]);	// 햄버거를 선택할 수 있는 거리 k
		
		String[] pos = br.readLine().split("");	// 햄버거와 사람 위치 저장할 배열
		int ans = 0;	// 햄버거를 먹을 수 있는 최대 사람 수
		for(int i=0;i<n;i++) {
			if(!pos[i].equals("P")) continue;
			
			// i-k 부터 i+k 위치까지 햄버거가 있는지 탐색 (배열 크기 벗어나지 않도록 예외 처리)
			for(int j=Math.max(0, i-k);j<=Math.min(n-1, i+k);j++) {
				// 햄버거가 있다면 ans 1만큼 증가시키고, 해당 위치의 문자는 "H" 대신 "N" 문자로 대체해줌
				if(pos[j].equals("H")) {
					ans++;
					pos[j] = "N";
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}
