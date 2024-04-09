import java.io.*;
import java.util.*;

public class BOJ_2609 {
	public static int GCD(int x, int y) {
		while(y!=0) {
			int r=x%y;
			
			x=y;
			y=r;
		}
		
		return x;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		int x=a;
		int y=b;
		int gcd=GCD(x,y);
		
		System.out.println(gcd);
		System.out.println(x*y/gcd);
	}
}
