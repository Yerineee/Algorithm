import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] setSize = br.readLine().split(" ");	// 입력 받은 집합 A와 B의 원소 개수
		
		HashSet<Integer> A = new HashSet<>();	// 집합 A
		HashSet<Integer> B = new HashSet<>();	// 집합 B
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력 받은 집합 A의 모든 원소 저장하기
		for(int i=0;i<Integer.parseInt(setSize[0]);i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		// 입력 받은 집합 B의 모든 원소 저장하기
		for(int i=0;i<Integer.parseInt(setSize[1]);i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		A.retainAll(B);	// 집합 A와 B의 교집합을 A에 저장하기
		
		// (집합 A와 B의 대칭 차집합의 크기) = (집합 A의 크기) + (집합 B의 크기) - 2*(집합 A와 B의 교집합의 크기)
		System.out.println(Integer.parseInt(setSize[0])+Integer.parseInt(setSize[1])-2*A.size());
	}
}
