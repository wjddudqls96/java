import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		
		String line = in.readLine();
		boolean isLazer = true;
		int stickCnt = 0;
		int result = 0;
		
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '(') {
				stack.push(line.charAt(i));
				stickCnt++;
				isLazer = true;
			}
			else {
				// 레이저라면
				if(isLazer) {
					stack.pop();
					stickCnt--;
					result += stickCnt;
					isLazer = false;
				}
				// 막대끝이라면
				else {
					result++;
					stickCnt--;
				}
			}
		}
		
		System.out.println(result);
	}
	
}