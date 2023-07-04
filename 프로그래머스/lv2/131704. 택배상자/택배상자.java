import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int orderIdx = 1;
        int start = 0;
        
        
        while(true){
            boolean flag = false;
            
            if(!stack.isEmpty() && order[start] == stack.peek()){
                answer++;
                start++;
                stack.pop();
                continue;
            }
            
            if(orderIdx > order.length) break;
            
            if(order[start] == orderIdx){
                answer++;
                start++;
                orderIdx++;
                
                continue;
            }
            
            stack.push(orderIdx);
            orderIdx++;
        }
        
        return answer;
    }
}