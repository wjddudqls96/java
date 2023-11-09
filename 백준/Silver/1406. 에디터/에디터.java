import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String str = in.readLine();
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));
		}
		
		int M = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			String command = st.nextToken();
			
			switch (command) {
				case "L":
					if(!left.isEmpty()) {
						right.push(left.pop());
					}
					
					break;
				case "D":
					if(!right.isEmpty()) {
						left.push(right.pop());
					}
					break;
				case "B":
					if(!left.isEmpty()) {
						left.pop();
					}
					break;
				case "P":
					char c = st.nextToken().charAt(0);
					left.push(c);
					break;
			}
		}
		
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb);
	}
}