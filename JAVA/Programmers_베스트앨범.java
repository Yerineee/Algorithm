import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        HashMap<String, Integer> playSum = new HashMap<>(); // 장르 별 재생 횟수
        String[] sortedArr = new String[genres.length];     // 노래 수록 기준에 따라 정렬한 배열
        
        for(int i=0;i<genres.length;i++) {
            sortedArr[i] = Integer.toString(i);
            
            // 해당 장르의 재생 횟수 합계 갱신
            playSum.put(genres[i], playSum.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        Arrays.sort(sortedArr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                int o1 = Integer.parseInt(s1);
                int o2 = Integer.parseInt(s2);
                // 장르의 재생 횟수가 같다면
                if(playSum.get(genres[o1]) == playSum.get(genres[o2])) {
                    // 해당 노래의 재생 횟수가 같다면
                    if(plays[o1] == plays[o2]) {
                        // 노래의 고유번호 기준으로 오름차순 정렬
                        return o1-o2;
                    }
                    
                    // 노래의 재생 횟수를 기준으로 내림차순 정렬
                    return plays[o2]-plays[o1];
                }
                
                // 장르의 재생 횟수를 기준으로 내림차순 정렬
                return playSum.get(genres[o2])-playSum.get(genres[o1]);
            }
        });
        
        String genre = "";  // 장르
        int cnt = 0;        // 해당 장르의 노래 중 수록된 노래 수
        for(int i=0;i<sortedArr.length;i++) {
            int num = Integer.parseInt(sortedArr[i]);   // 현재 노래의 고유번호
            // 해당 장르의 노래 중 수록된 노래가 2개 이상이면 넘어가기
            if(genre.equals(genres[num]) && cnt>=2) continue;
            
            ans.add(num);
            // genre와 해당 노래의 장르가 다르면 genre와 cnt 갱신
            if(!genre.equals(genres[num])) {
                genre = genres[num];
                cnt = 1;
            } else {
                cnt++;
            }
        }
        
        return ans.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
