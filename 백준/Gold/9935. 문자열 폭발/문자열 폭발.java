import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		String line = in.readLine();
		String regax = in.readLine();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < line.length(); i++) {
			stack.push(line.charAt(i));
			
			// 만약 스택에 들어있는 크기가 폭발 문자열의 길이보다 길거나 같다면.
			if(stack.size() >= regax.length()) {
				boolean flag = true;
				
				for(int j = 0; j < regax.length(); j++) {
					if(stack.get(stack.size() - regax.length() + j) != regax.charAt(j)) {
						flag = false;
					}
				}
				
				if(flag) {
					for(int j = 0; j < regax.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.size() == 0) {
			sb.append("FRULA");
		}
		else {
			for(int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		}
		
		System.out.println(sb);
	}
}