import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int n, m;
    static int[] arr;
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	arr = new int[n + 1];
    	makeSet();
    	
    	for(int c = 0; c < m; c++) {
    		st = new StringTokenizer(in.readLine());
    		
    		int command = Integer.parseInt(st.nextToken());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		// 유니온 메소드 호출. 
    		if(command == 0) {
    			union(a, b);
    		}
    		// 같은 집합에 있는지 체크.
    		else if(command == 1){
    			if(findSet(a) == findSet(b)) {
    				sb.append("YES");
    			}
    			else {
    				sb.append("NO");
    			}
    			sb.append("\n");
    		}
    	}
    	
    	System.out.println(sb);
    	
    }
	static void makeSet() {
		for(int i = 0; i <= n; i++) {
			arr[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(x == arr[x]) {
			return x;
		}
		
		return arr[x] = findSet(arr[x]);
	}
	
	static void union(int x, int y) {
		if(x != y) {
			arr[findSet(y)] = findSet(x);
		}
	}
}