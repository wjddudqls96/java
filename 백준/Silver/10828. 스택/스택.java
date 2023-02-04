import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		stack = new Stack<Integer>();
		
		for(int i = 0; i < N; i++) {
			String[] line = in.readLine().split(" ");
			readCommand(line);
		}
	}
	
	static void readCommand(String[] line) {
		switch(line[0]) {
		case "push":
			stack.add(Integer.parseInt(line[1]));
			break;
		case "pop":
			if(stack.isEmpty()) {
				System.out.println(-1);
			}
			else {
				System.out.println(stack.pop());
			}
			break;
		case "size":
			System.out.println(stack.size());
			break;
		case "empty":
			if(stack.isEmpty()) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			break;
		case "top":
			if(stack.isEmpty()) {
				System.out.println(-1);
			}
			else {
				System.out.println(stack.lastElement());
			}
			break;
		}
	}
}