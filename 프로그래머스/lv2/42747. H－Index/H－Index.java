import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++){
            int cnt = citations[i];
            int h = citations.length - i;
            
            if(cnt >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}