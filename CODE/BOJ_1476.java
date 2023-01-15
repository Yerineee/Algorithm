import java.io.*;
import java.util.*;

public class BOJ_1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int E=Integer.parseInt(st.nextToken());	// 지구
		int S=Integer.parseInt(st.nextToken());	// 태양
		int M=Integer.parseInt(st.nextToken());	// 달

		int i=0, year;
		while(true) {
			year=E+15*i;
			if(year-S>=0 && (year-S)%28==0) {
				if(year-M>=0 && (year-M)%19==0) {
					break;
				}
			}
			
			i++;
		}	
		
		System.out.printf("%d", year);
	}
}
