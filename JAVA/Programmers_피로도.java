class Solution {
    static int answer;
    static boolean[] visit;
    
    // 완전 탐색 이용
    public static void search(int[][] dungeons, int k, int result) {
        for(int i=0;i<dungeons.length;i++) {
            // 탐험하지 않은 던전이고, 최소 필요 피로도보다 현재 피로도가 더 크거나 같다면 해당 던전 탐험하기
            if(!visit[i] && dungeons[i][0]<=k) {
                visit[i] = true;
                search(dungeons, k-dungeons[i][1], result+1);
                visit[i] = false;
            }
        }
        
        answer = Math.max(answer, result);
    }
    
    // 현재 피로도 k, 최소 필요 피로도/소모 피로도가 담긴 2차원 배열 dungeons
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        
        visit = new boolean[dungeons.length];   // 던전 탐험 여부 체크할 배열
        
        search(dungeons, k, 0);
        
        return answer;
    }
}
