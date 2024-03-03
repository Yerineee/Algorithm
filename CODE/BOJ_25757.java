import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25757 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 플레이하기를 신청한 횟수
		String type = st.nextToken();	// 플레이할 게임의 종류
		
		Set<String> set = new HashSet<>();	// 플레이어 이름 중복을 피하기 위한 set 이용
		for(int i=0;i<n;i++) {
			set.add(br.readLine());	// set에 플레이어 이름 저장
		}
		
		int ans=0;	// 최대로 플레이할 수 있는 게임 횟수
		// 게임 종류에 따라 횟수 구하기
		switch(type) {
		// 윷놀이의 경우, 임스를 제외한 1명 필요
		case "Y":
			ans = set.size();
			break;
		// 같은 그림 찾기의 경우, 임스를 제외한 2명 필요
		case "F":
			ans = set.size()/2;
			break;
		// 원카드의 경우, 임스를 제외한 3명 필요
		default:
			ans = set.size()/3;
		}

		System.out.println(ans);
	}
}
