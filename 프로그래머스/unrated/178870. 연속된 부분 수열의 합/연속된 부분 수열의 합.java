import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int i, j, sum, min;
        i = 0; 
        j = 0;
        sum = sequence[0];
        min = Integer.MAX_VALUE;
        
        while(true){
            
            if(sum == k){
                // 2. 만약 k와 값이 같다면 min에 저장
                if(min > (i - j + 1)){
                    min = i - j + 1;
                    answer[0] = j;
                    answer[1] = i;
                }
                else if(min == (i - j + 1)){
                    if(answer[0] > j){
                        answer[0] = j;
                        answer[1] = i;
                    }
                }
            }
            
            if(i == sequence.length && j == sequence.length) break;
            // 1. 합보다 k가 더크다면 i를 늘려준다.
            if(sum <= k && i < sequence.length){
                i++;
                if(i < sequence.length){
                    sum += sequence[i];
                }
            }
            else{
                if(j < sequence.length){
                    sum -= sequence[j];
                }
                j++;
            }
            
            
        }
        
        return answer;
    }
}