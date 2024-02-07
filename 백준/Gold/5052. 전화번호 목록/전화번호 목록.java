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
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.readLine());
			boolean isStrange = false;
			String[] strArr = new String[N];
			
			for(int i = 0; i < N; i++) {
				strArr[i] = in.readLine();
			}
			
			Arrays.sort(strArr);
			
			for (int i = 0; i < N - 1; i++) {
	            if (strArr[i + 1].startsWith(strArr[i])) {
	            	isStrange = true;
	            }
	        }
			
			if(isStrange) {
				sb.append("NO").append("\n");
			}
			else {
				sb.append("YES").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}