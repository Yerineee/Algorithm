import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                // col번째 컬럼 값이 동일하면 첫 번째 컬럼 값을 기준으로 내림차순 정렬
                if(o1[col-1] == o2[col-1]) {
                    return o2[0] - o1[0];
                }
                
                // col번째 컬럼 값을 기준으로 오름차순 정렬
                return o1[col-1] - o2[col-1];
            }
        });
        
        // i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합
        int[] s_i = new int[data.length];
        for(int i=row_begin;i<=row_end;i++) {
            for(int j=0;j<data[0].length;j++) {
                s_i[i-1] += data[i-1][j]%i;
            }
            
            // S_i를 누적하여 bitwise XOR 한 값
            answer ^= s_i[i-1];
        }
        
        return answer;
    }
}
