import java.io.*;
import java.util.*;

public class BOJ_1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());	// 입력 받은 수의 개수
		int ans=0;	// 소수의 개수
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(st.nextToken());	// 입력 받은 수
			
			int cnt=0;	// 입력 받은 수의 약수 개수
			for(int j=1;j<=num/2;j++) {
				if(num%j==0) {		// num이 j로 나누어지면 j는 num의 약수
					if(j==num/j)	// 약수가 중복되어 세어지지 않도록 if문 이용
						cnt++;
					else
						cnt+=2;
				}
			}
			
			if(cnt==2) {	// 약수의 개수가 2인 경우(1과 자기자신)
				ans++;		// 소수 개수 1만큼 증가
			}
		}
		
		System.out.println(ans);	// 소수의 개수 출력
	}
}
