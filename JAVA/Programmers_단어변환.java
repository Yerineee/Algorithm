import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static int bfs(String begin, String target, String[] words) {
        Queue<String[]> queue = new LinkedList<>();
        boolean[] visit = new boolean[words.length];    // 방문 확인할 배열
        
        queue.add(new String[]{begin, "0"});
        
        while(!queue.isEmpty()) {
            String[] cur = queue.poll();
            String str = cur[0];                // 단어
            int num = Integer.parseInt(cur[1]); // 횟수
            
            // 꺼낸 단어가 target과 같은 단어라면, 횟수 반환
            if(str.equals(target)) {
                return num;
            }
            
            for(int i=0;i<words.length;i++) {
                boolean flag = false; // 한 개의 알파벳만 다른지 체크
                for(int j=0;j<str.length();j++) {
                    if((str.substring(0,j)+str.substring(j+1)).equals(words[i].substring(0,j)+words[i].substring(j+1))) {
                        flag = true;
                        break;
                    }
                }
                
                // 방문한 적 없는 단어이고 한 개의 알파벳만 다른 경우, 큐에 저장
                if(flag && !visit[i]) {
                    visit[i] = true;
                    queue.add(new String[]{words[i], Integer.toString(num+1)});
                }
            }
            
        }
        
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = bfs(begin, target, words);
        
        return answer;
    }
}
