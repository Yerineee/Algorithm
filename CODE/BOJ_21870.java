import java.util.*;
import java.io.*;

public class BOJ_21870 {
	static int[] S;
	static int N;
	
	public static int gcd(int a, int b) {	// 유클리드 호제법 (GCD 구하기)
		while(b!=0) {
			int tmp = a;
			a = b;
			b = tmp%b;
		}
		
		return a;
	}
	
	public static int getGCD(int start, int end) {
		int x=S[start];
		for(int i=start+1;i<end;i++)
			x=gcd(x, S[i]);
		
		return x;
	}
	
	public static int calc(int start, int end) {
		if(start==(end-1)) 
			return S[start];
		
		else if((end-1)-start==1)
			return S[start]+S[end-1];
		
		int mid=(end-start)/2;
		return Math.max(getGCD(start, start+mid)+calc(start+mid, end), getGCD(start+mid, end)+calc(start, start+mid));	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		N = Integer.parseInt(br.readLine());	// 정수 N
		S= new int[N];	// 매물번호 배열 S
		int mid=N/2;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			S[i]=Integer.parseInt(st.nextToken());
		}
		
		if(S.length==1)
			sb.append(S[0]);
		else {
			sb.append(Math.max(getGCD(mid, N)+calc(0, mid), getGCD(0, mid)+calc(mid, N)));
		}
		
		System.out.println(sb.toString());
	}
}
