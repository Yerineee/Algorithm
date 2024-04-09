class Solution {
    static int answer;
    static boolean[] check;
    
    public static void dfs(int num, int n, int[][] computers) {
        check[num]=true;
        
        for(int i=0;i<n;i++) {
            if(!check[i] && computers[num][i]==1) {
                dfs(i, n, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        check=new boolean[n];
        
        for(int i=0;i<n;i++) {
            if(!check[i]) {
                answer++;
                dfs(i, n, computers);
            }
        }
        
        return answer;
    }
}
