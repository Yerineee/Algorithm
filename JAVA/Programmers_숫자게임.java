import java.util.*;

class Solution {    
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int ans = 0;
        for(int i=0;i<B.length;i++) {
            if(A[ans] < B[i]) {
                ans++;
            }
        }
        
        return ans;
    }
}
