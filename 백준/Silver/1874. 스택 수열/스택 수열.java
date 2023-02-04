import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack;
    static int[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		result = new int[N];
		stack = new Stack<Integer>();
		
		for(int i = 0; i < N; i++) {
			result[i] = Integer.parseInt(in.readLine());
		}
		
		int count = 0;
		int index = 1;
		
		while(index <= N) {
			if(result[count] == index) {
				sb.append("+").append("\n");
				sb.append("-").append("\n");
				count++;
				index++;
			}
			else if(!stack.isEmpty() && stack.lastElement() == result[count]) {
				sb.append("-").append("\n");
				stack.pop();
				count++;
			}
			else {
				stack.push(index);
				sb.append("+").append("\n");
				index++;
			}
		}
		
		boolean flag = true;
		
		for(int i = count; i < N; i++) {
			int num = stack.pop();
			if(result[count] != num) {
				flag = false;
				break;
			}
			sb.append("-").append("\n");
			count++;
		}
		
		if(flag) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
		
	}
}