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
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[1001];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int index = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			max = Math.max(max, index);
			min = Math.min(min, index);
			arr[index] = height;
		}
		
		int maxHeight = 0;
		Stack<Integer> stack = new Stack<>();
		maxHeight = arr[min];
		
		for(int i = min + 1; i <= max; i++) {
			int cur = arr[i];
			
			if(maxHeight > cur) {
				stack.push(i);
			}
			else {
				while(!stack.isEmpty()) {
					int temp = stack.pop();
					arr[temp] = maxHeight;
				}

				maxHeight = cur;
			}
		}
		
		stack.clear();
		
		maxHeight=arr[max];
		
		for(int i = max - 1; i >= min; i--) {
			int cur = arr[i];
			
			if(maxHeight > cur) {
				stack.push(i);
			}
			else {
				while(!stack.isEmpty()) {
					int temp = stack.pop();
					arr[temp] = maxHeight;
				}

				maxHeight = cur;
			}
		}
		
		 int result = 0;
	     for (int i = min; i <= max; i++) {
	    	 result += arr[i];
	     }
		
		
		System.out.println(result);
	}
}