import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	private static int H, W;
	private static int[] arr;
	private static char[] cArr = {' ', '+', '-'};
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		int t = Integer.parseInt(in.readLine());
		
		for(int testCase = 0; testCase < t; testCase++) {
			int num = Integer.parseInt(in.readLine());
			dfs("1", 1, num);
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
        
	}
	
	static void dfs(String str, int count, int target) {
		if(target == count) {
			String newStr = str.replaceAll(" ", "");
			int result = operation(newStr);
			
			if(result == 0) {
				sb.append(str).append("\n");
			}
			
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			dfs(str + cArr[i] + (count + 1), count + 1, target);
		}
	}
	
	static int operation(String str) {
		StringTokenizer st = new StringTokenizer(str, "+|-", true);
		int sum = Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			
			if(s.equals("+")) {
				sum += Integer.parseInt(st.nextToken());
			}
			else {
				sum -= Integer.parseInt(st.nextToken());
			}
		}
		
		return sum;
	}
}