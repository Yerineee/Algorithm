import java.util.*;

class Solution {
    public static int[] dx = {1, 0, 1};
    public static int[] dy = {0, 1, 1};
    public static Set<String> set = new HashSet<>();
    public static int ans = 0;
    
    // 사라질 블록이 있는지 확인하는 함수
    public static boolean checkBlock(int m, int n, String[] board) {
    	set.clear();
    	
        for(int i=0;i<m-1;i++) {
            for(int j=0;j<n-1;j++) {
            	if(board[i].charAt(j) == '.') continue;
            	
                for(int k=0;k<3;k++) {
                    if(board[i].charAt(j) != board[i+dy[k]].charAt(j+dx[k])) break;
                    
                    // 4개의 블록이 모두 같은 문자이면, 해당 블록의 위치(행, 열)를 set에 저장
                    if(k==2) {
                        set.add(i+","+j);
                        set.add((i+1)+","+j);
                        set.add(i+","+(j+1));
                        set.add((i+1)+","+(j+1));
                    }
                }
            }
        }
        // 지울 블록 개수 세기
        ans += set.size();
        
        return set.size()>0 ? true : false;
    }
    
    // 블록을 지우는 함수
    public static String[] removeBlock(int m, int n, String[] board) {
        Iterator<String> it = set.iterator();
        
        while(it.hasNext()) {
            String[] cur = it.next().split(",");
            int row = Integer.parseInt(cur[0]);
            int col = Integer.parseInt(cur[1]);
            
            // 지워지는 블록은 '.'으로 표시하기
            board[row] = board[row].substring(0, col) + '.' + board[row].substring(col+1);
        }
        
        return board;
    }
    
    // 블록을 아래로 내리는 함수
    public static String[] dropBlock(int m, int n, String[] board) {
        for(int i=0;i<n;i++) {
            for(int j=m-2;j>=0;j--) {
            	if(board[j].charAt(i) == '.') continue;
            	
            	for(int k=m-1;k>j;k--) {
            		if(board[k].charAt(i) == '.') {
            			board[k] = board[k].substring(0, i) + board[j].charAt(i) + board[k].substring(i+1);
            			board[j] = board[j].substring(0, i) + '.' + board[j].substring(i+1);
            			break;
            		}
            	}
            }
        }
        
        return board;
    }
    
    public int solution(int m, int n, String[] board) {
        // 지울 블록이 있다면 계속 블록 탐색
        while(checkBlock(m, n, board)) {
            // 블록 지우기
            board = removeBlock(m, n, board);
            // 블록 아래로 내리기
            board = dropBlock(m, n, board);
        }
    
        return ans;
    }
}
