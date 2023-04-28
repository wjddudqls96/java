import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int last = -1;
        for(int i = 0; i < targets.length; i++){
            int[] target = targets[i];
            // 맨처음이라면
            if(last == -1){
                answer++;
                last = target[1] - 1;
            }
            else{
                
                if(target[0] <= last && target[1] >= last) continue;
                
                last = target[1] - 1;
                answer++;
            }
        }
        
        return answer;
    }
}