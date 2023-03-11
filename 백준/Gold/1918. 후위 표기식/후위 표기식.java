import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        String line = in.readLine();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < line.length(); i++) {
        	char c = line.charAt(i);
        	
        	if(isNumber(c)) {
        		sb.append(c);
        	}
        	
        	else if(c == '*' || c == '+' || c == '-' || c == '/') {
        		if(stack.isEmpty()) {
        			stack.push(c);
        		}
        		else {
        			while(!stack.isEmpty() && getpriority(stack.peek(), c) >= 0) {
        				sb.append(stack.pop());
        			}
        			stack.push(c);
        		}
        	}
        	
        	else if(c == '(') {
        		stack.push(c);
        	}
        		
        	else if(c == ')') {
        		while(!stack.isEmpty() && stack.peek() != '(') {
        			sb.append(stack.pop());
        		}
        		stack.pop();
        	}
        }
        
        while(!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        
        System.out.println(sb);
    }
    
    static boolean isNumber(char c) {
    	if(c == '*' || c == '+' || c == '-' || c == '/' || c == '(' || c == ')')
    		return false;
    	return true;
    }
    
    static int getpriority(char a, char b) {
    	return priority(a) - priority(b);
    }
    
    static int priority(char a) {
    	switch (a) {
		case '+':
			return 1;
		case '-': 
			return 1;
		case '*': 
			return 2;
		case '/': 
			return 2;
    	}
    	
    	return -1;
    }
}