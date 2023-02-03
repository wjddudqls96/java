import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int k = Integer.parseInt(in.readLine());
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	
    	for(int i = 0; i < k; i++) {
    		int num = Integer.parseInt(in.readLine());
    		if(num == 0 && !stack.isEmpty()) {
    			stack.pop();
    		}
    		else {
    			stack.add(num);
    		}
    	}
    	
    	int sum = 0;
    	while(!stack.isEmpty()) {
    		sum += stack.pop();
    	}
    	
    	System.out.println(sum);
    }
}