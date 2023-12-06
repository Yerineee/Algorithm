import java.util.Arrays;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);  // A 배열 오름차순 정렬
        Arrays.sort(B);  // B 배열 오름차순 정렬
        
        for(int i=0;i<A.length;i++) {
            answer += A[i]*B[B.length-1-i];  // A 배열에서 (i+1)번째로 작은 수와 B 배열에서 (i+1)번째로 믄 수 곱하여 answer에 더하기
        }

        return answer;
    }
}
