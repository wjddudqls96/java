import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
class Node{
	int index;
	int num;
	
	public Node(int index, int num) {
		super();
		this.index = index;
		this.num = num;
	}
}
public class Main {
	static int K;
	static int num;
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        Stack<Node> stack = new Stack<>();
        int[] arr = new int[N];
        int index = new Integer(N);
        boolean flag = false;
        int count = 1;
        num = -1;
        while(N > 0) {
        	// 새 값을 꺼내야 된다면...
        	if(!flag) {
        		if(num == -1) {
        			num = Integer.parseInt(st.nextToken());
        		}
        		// 스택에 값이 없다면..
        		if(stack.isEmpty()) {
        			stack.add(new Node(count++, num));
        			arr[index - N] = 0;
        			N--;
        			num = -1;
        		}
        		// 왼쪽에 값이 있다면
        		else {
        			// 바로 왼쪽값이 나보다 크다면
        			if(stack.peek().num >= num) {
        				flag = false;
        				arr[index - N] = stack.peek().index;
        				stack.add(new Node(count++, num));
        				N--;
        				num = -1;
        			}
        			else {
        				flag = true;
        			}
        		}
        	}
        	// 새 값을 꺼내지 않는다면...
        	else {
        		stack.pop();
        		if(stack.isEmpty() || stack.peek().num >= num) {
        			flag = false;
        		}
        	}
        }
        
        for(int num : arr) {
        	sb.append(num + " ");
        }
        System.out.println(sb);
    }
}