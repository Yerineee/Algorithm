import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 첫 번째 풀이
public class BOJ_1205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());		// 리스트에 있는 점수 개수 N
		Long newScore = Long.parseLong(st.nextToken());	// 새로운 점수
		int p = Integer.parseInt(st.nextToken());		// 랭킹 리스트에 올라갈 수 있는 점수 개수 P
	
		String input;
		ArrayList<Long> list = new ArrayList<>();
		// 리스트에 점수가 있다면 점수 저장하기
		if((input=br.readLine())!=null) {
			st = new StringTokenizer(input);
			
			// ArrayList에 점수 저장하기
			while(st.hasMoreTokens()) {
				list.add(Long.parseLong(st.nextToken()));
			}
		}
		list.add(newScore);	// 리스트에 새로운 점수도 저장하기

		// 리스트를 내림차순으로 정렬하기
		Collections.sort(list, Collections.reverseOrder());
		
		int ans = 1;	// 새로운 점수의 랭킹 리스트 등수
		for(int i=1;i<list.size();i++) {
			if(list.get(i)<newScore) {
				break;
			}
			if(i > p-1) {
				ans = -1;
				break;
			}
			
			if(list.get(i)<list.get(i-1)) {
				ans = i+1;
			}
		}
		
		System.out.println(ans);
	}
}
*/

// 두 번째 풀이
public class BOJ_1205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());		// 리스트에 있는 점수 개수 N
		Long newScore = Long.parseLong(st.nextToken());	// 새로운 점수
		int p = Integer.parseInt(st.nextToken());		// 랭킹 리스트에 올라갈 수 있는 점수 개수 P
	
		// 기존 리스트에 저장된 점수가 없다면 새로운 점수가 1등이 된다.
		if(n==0) {
			System.out.println(1);
			return;
		}
		
		ArrayList<Long> list = new ArrayList<>();
		// 리스트에 점수가 있다면 점수 저장하기
		st = new StringTokenizer(br.readLine());
			
		// ArrayList에 점수 저장하기
		while(st.hasMoreTokens()) {
			list.add(Long.parseLong(st.nextToken()));
		}
		// 리스트를 내림차순으로 정렬하기
		Collections.sort(list, Collections.reverseOrder());
		
		// 기존 리스트에 저장된 점수 중 최하위 점수가 새로운 점수보다 크거나 같고, 리스트 크기와 p가 같으면 새로운 점수가 랭킹 리스트에 올라갈 수 없다.
		if(list.get(list.size()-1)>=newScore && list.size()==p) {
			System.out.println(-1);
			return;
		}
		
		int ans = 1;	// 새로운 점수의 랭킹 리스트 등수
		for(int i=0;i<list.size();i++) {
			if(list.get(i)>newScore) {
				ans++;
			} else {
				ans = i+1;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
