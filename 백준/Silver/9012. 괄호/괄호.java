import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(in.readLine());
    	
    	for(int i = 0; i < N; i++) {
    		String str = in.readLine();
    		
    		Stack<Character> stack = new Stack<>();
    		boolean isBreak = false;
    		
    		for(int j = 0; j < str.length(); j++) {
    			char c = str.charAt(j);
    			
    			if(c == '(') {
    				stack.push(c);
    			}
    			else {
    				
    				if(stack.isEmpty()) {
    					isBreak =true;
    					break;
    				}
    				else {
    					stack.pop();
    				}
    			}
    		}
    		
    		
    		
    		if(isBreak || !stack.isEmpty()) {
    			sb.append("NO").append("\n");
    		}
    		else {
    			sb.append("YES").append("\n");
    		}
    	}
    	
    	System.out.println(sb);
	}
}