import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			String command = in.readLine();
			int size = Integer.parseInt(in.readLine());
			String[] split = in.readLine().split("[\\[\\],]");
			
			Deque<Integer> dq = new ArrayDeque<>();
			
			
			for(int i = 1; i <= size; i++) {
				dq.offer(Integer.parseInt(split[i]));
			}
			
			boolean isError = false;
			boolean isLeft = true;
			for(int i = 0; i < command.length(); i++) {
				if(command.charAt(i) == 'R') {
					if(isLeft) {
						isLeft = false;
					}else {
						isLeft = true;
					}
				}
				else if(command.charAt(i) == 'D'){
					if(dq.isEmpty()) {
						isError = true;
						break;
					}
					else {
						if(isLeft) {
							dq.pollFirst();
						}
						else {
							dq.pollLast();
						}
					}
				}
			}
			
			if(isError) {
				sb.append("error").append("\n");
			}
			else {
				if(isLeft) {
					sb.append(dq).append("\n");
				}
				else {
					Deque<Integer> cq = new ArrayDeque<>();
					while(!dq.isEmpty()) {
						cq.offer(dq.pollLast());
					}
					sb.append(cq).append("\n");
				}
			}
		}
		System.out.println(sb.toString().replace(" ", ""));
	}
}