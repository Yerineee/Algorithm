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
			year=E+15*i;	//연도
			if(year-S>=0 && (year-S)%28==0) {	// 만약 (해당 연도-S)가 0보다 크거나 같고 28로 나누어떨어지고
				if(year-M>=0 && (year-M)%19==0) { // 만약 (해당 연도-M)가 0보다 크거나 같고 19로 나누어떨어지면
					break;	// 반복문 종료
				}
			}
			
			i++;
		}	
		
		System.out.printf("%d", year);	// 연도 출력
	}
}
