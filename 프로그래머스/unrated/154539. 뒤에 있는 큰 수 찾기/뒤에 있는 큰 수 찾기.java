import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numbers.length; i++){
            
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                    int index= stack.pop();
                    numbers[index] = numbers[i];
                }
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            numbers[stack.pop()] = -1;
        }
        
        return numbers;
    }
}