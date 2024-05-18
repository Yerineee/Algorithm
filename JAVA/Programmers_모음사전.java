// 1. ArrayList 이용하여 작성
import java.util.*;

class Solution {
    static ArrayList<String> dic = new ArrayList<>(Arrays.asList("A", "E", "I", "O", "U"));
    static HashMap<String, Integer> map = new HashMap<>();
    
    public static void dfs(String str, int len) {
        map.put(str, map.size());   // 현재 단어를 HashMap에 저장
        
        if(len == 5) return;    // 현재 단어의 길이가 5이면 돌아가기
        
        for(int i=0;i<5;i++) {
            dfs(str+dic.get(i), len+1);
        }
    }
    
    public int solution(String word) {
        // HashMap에 모든 단어를 저장
        dfs("", 0);
        
        // 찾으려는 word가 몇 번째 단어인지 검색
        return map.get(word);
    }
}

// 2. charAt() 이용하여 조금 더 간단하게 작성
/*
import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    
    public static void dfs(String str, int len) {
        map.put(str, map.size());   // 현재 단어를 HashMap에 저장
        
        if(len == 5) return;    // 현재 단어의 길이가 5이면 돌아가기
        
        for(int i=0;i<5;i++) {
            dfs(str+"AEIOU".charAt(i), len+1);
        }
    }
    
    public int solution(String word) {
        // HashMap에 모든 단어를 저장
        dfs("", 0);
        
        // 찾으려는 word가 몇 번째 단어인지 검색
        return map.get(word);
    }
}
*/
