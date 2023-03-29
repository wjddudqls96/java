import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				int index = stack.pop();
				arr[index] = arr[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			int index = stack.pop();
			arr[index] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb);
	}
}