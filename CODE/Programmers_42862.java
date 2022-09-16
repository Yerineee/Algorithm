package го;

import java.util.Arrays;
public class Programmers_42862 {
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student=new int[n+2];
        
        Arrays.fill(student,1);
        for(int num:lost) {
            student[num]--;
        }
        for(int num:reserve) {
            student[num]++;
        }
        
        for(int i=1;i<n+1;i++) {
            if(student[i]==1||student[i]==2) {
                answer++;
            }
            else if(student[i]==0) {
                if(student[i-1]==2) {
                    answer++;
                    student[i-1]--;
                }
                else if(student[i+1]==2) {
                    answer++;
                    student[i+1]--;
                }
            }
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		int n = 5;
		
		System.out.println(solution(n,lost,reserve));

	}
}
