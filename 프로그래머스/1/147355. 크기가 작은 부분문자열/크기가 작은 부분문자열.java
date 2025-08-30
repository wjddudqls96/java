import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        
        // p를 숫자로 변환
        long pNum = Long.parseLong(p);
        
        // 슬라이딩 윈도우
        for (int i = 0; i <= t.length() - len; i++) {
            String sub = t.substring(i, i + len);
            long subNum = Long.parseLong(sub);
            
            // p보다 작거나 같으면 카운트
            if (subNum <= pNum) {
                answer++;
            }
        }
        
        return answer;
    }
}