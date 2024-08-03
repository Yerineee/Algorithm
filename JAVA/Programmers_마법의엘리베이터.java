class Solution {
    public int solution(int storey) {
        int ans = 0;
        
        while(storey > 0) {
            int num = storey%10;            // 일의 자릿수
            int upperNum = (storey%100)/10; // 십의 자릿수
            
            // 일의 자릿수가 5보다 크거나, 일의 자릿수가 5이고 십의 자릿수가 5 이상이면
            if(num>5 || num==5 && upperNum>=5) {
                // 엘리베이터를 (10-num)만큼 올라갔다가 내려감
                ans += (10-num);
                storey += 10;
            } else {
                // 그렇지 않은 경우, num만큼 내려감
                ans += num;
            }
            
            storey /= 10;
        }
        
        return ans;
    }
}
