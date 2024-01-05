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

class Box {
	int index;
	int count;
	
	public Box(int index, int count) {
		this.index = index;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return this.index + " " + count;
	}
}


public class Main {
    static int N;
    static int[] arr;
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	arr = new int[N];
    	Box[] boxes = new Box[N];
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	st = new StringTokenizer(in.readLine());
    	
    	for(int i = 0; i < N; i++) {
    		int num = Integer.parseInt(st.nextToken()); 
    		arr[i] = num;
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	
    	for(int i = 0; i < N; i++) {
    		boxes[i] = new Box(i, map.get(arr[i]));
    	}
    	
    	// stack으로 값 구하기.
    	int[] results = new int[N];
    	
    	Stack<Box> stack = new Stack<>();
    	
    	for(int i = 0; i < N; i++) {
    		Box box = boxes[i];
    		
    		if(!stack.isEmpty() && stack.peek().count < box.count) {
    			
    			while(!stack.empty()) {
    				
    				if(stack.peek().count >= box.count) {
    					break;
    				};
    				
    				Box prevBox = stack.pop();
    				results[prevBox.index] = arr[box.index];
    			}
    		}
    		
    		stack.push(box);
    	}
    	
    	while(!stack.isEmpty()) {
    		Box box = stack.pop();
    		results[box.index] = -1;
    	}
    	
    	for(int result : results) {
    		sb.append(result + " ");
    	}
    	
    	System.out.println(sb);
    }
}