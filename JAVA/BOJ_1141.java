import java.io.*;
import java.util.*;

public class BOJ_1141 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());	// 단어 개수 N
		HashSet<String> set = new HashSet<String>();// 집합 (단어 중복 없애기 위함)
		
		for(int i=0;i<N;i++) {
			set.add(br.readLine());	// 집합에 단어 저장
		}
		
		ArrayList<String> list = new ArrayList<String>(set);
		int ans = list.size();	// 결과값
		
		for(int i=0;i<list.size();i++) {
			String str = list.get(i);	// 리스트의 i번째 값 변수에 저장
			for(int j=0;j<list.size();j++) {
				if(j!=i && list.get(j).startsWith(str)) { // 해당 문자열이 다른 단어의 접두어인 경우
					ans--;
					break;
				}
			}
		}
		
		
		bw.write(Integer.toString(ans)); // 결과값 출력
		bw.flush();
		bw.close();
	}
}
