import java.util.Arrays;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // participant 배열과 completion 배열 모두 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0;i<completion.length;i++) {
            // participant 배열과 completion 배열의 특정 인덱스 값이 다르면 answer 변수에 해당 인덱스의 선수 이름 저장
            if(!completion[i].equals(participant[i])) {
                answer = participant[i];
                break;
            }
        }

        // completion 마지막 선수까지 비교했을 때 participant 배열과 모두 일치했다면, participant의 마지막 선수를 answer 변수에 저장
        if(answer.equals("")) {
            answer = participant[participant.length-1];
        }
          
        return answer;
    }
}
