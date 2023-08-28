import java.util.*;

class Solution {
    private int size; 
    private int answer;
    public int solution(int[] numbers, int target) {
        size = numbers.length;
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    public void dfs(int cnt, int sum, int[] numbers, int target){
        if(cnt == size){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        
        dfs(cnt + 1, sum + numbers[cnt], numbers, target);
        dfs(cnt + 1, sum - numbers[cnt], numbers, target);
    }
}