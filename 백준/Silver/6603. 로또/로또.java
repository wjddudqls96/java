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
	static int V, E;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	String str;
    	
    	while(!(str = in.readLine()).equals("0")) {
    		st = new StringTokenizer(str);
    		int count = Integer.parseInt(st.nextToken());
    		
    		arr = new int[count];
    		visit = new boolean[count];
    		
    		for(int i = 0; i < count; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		combi(0, 0);
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
	}
	
	static void combi(int idx, int count) {
		if(count == 6) {
			for(int i = 0; i < visit.length; i++) {
				if(visit[i]) {
					sb.append(arr[i] + " ");
				}
			}
			sb.append("\n");
			return;
		}
		 
		for(int i = idx; i < arr.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				combi(i + 1, count + 1);
				visit[i] = false;
			}
		}
	}
}