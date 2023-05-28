import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        
        
        
        for(int i = 0; i < s.length(); i++){
            if(isPossible(stack, s)){
                answer++;
            }
            
            s = s.substring(1, s.length()) + s.substring(0, 1);
        }
        
        return answer;
    }
    
    static boolean isPossible(Stack<Character> stack, String str){
        boolean flag = true;
        
        for(int i = 0 ; i < str.length(); i++){
            char c = str.charAt(i);
            switch(c){
                case ')':
                    if(stack.isEmpty() || stack.peek() != '('){
                        flag = false;
                    }
                    else{
                       stack.pop();
                    }
                    break;
                case '}':
                     if(stack.isEmpty() || stack.peek() != '{'){
                        flag = false;
                    }
                    else{
                       stack.pop();
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '['){
                        flag = false;
                    }
                    else{
                       stack.pop();
                    }
                    break;
                default:
                    stack.push(c);
            }
            
            if(!flag) break;
        }
        
        return !stack.isEmpty() ? false : flag;
    }
}