import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long min = 0;
        long max = (long) n * times[times.length - 1];
        
        while(min <= max){
            long mid = (min + max) / 2;
            long sum = 0;
            
            for(int i = 0; i < times.length; i++){
                sum += mid / times[i];
            }
            
            if(sum < n){ // 처리해야될 사람보다 처리를 못했다면 mid를 높힌다.
                min = mid + 1;
            }
            else {
                max = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}