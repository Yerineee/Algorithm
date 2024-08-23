import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] answer;
    
    // 팩토리얼 계산하는 함수
    static long factorial(int num) {
        long res = 1;
        
        for(int i=1;i<=num;i++) {
            res *= i;
        }
        
        return res;
    }
    
    static void solve(int n, long k) {
        int cnt = 0; // 현재 구하고 있는 인덱스 번호
        
        while(cnt < n) {
            long fact = factorial(n-cnt-1);
            int idx = (int) (k/fact); // 현재 줄 서야 하는 사람의 list에서의 인덱스
            k %= fact; // k 업데이트

            answer[cnt++] = list.remove(idx); // answer에 해당 번호 저장한 뒤 리스트에서 그 사람 번호는 제거
        }
        
        return;
    }
    
    public int[] solution(int n, long k) {
        answer = new int[n];
        
        // 리스트에 사람들의 번호 저장
        for(int i=1;i<=n;i++) {
            list.add(i);
        }
        
        solve(n, k-1);
        
        return answer;
    }
}
