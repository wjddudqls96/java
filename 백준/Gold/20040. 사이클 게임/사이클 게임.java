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
    	
    	arr = new int[n];
    	makeSet();
    	
    	int result = 0;
    	
    	for(int c = 0; c < m; c++) {
    		st = new StringTokenizer(in.readLine());
    		
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		// 연결할 때 a의 부모와 b의 부모가 이미 같다면 이것은 사이클이다. 
    		if(findSet(a) == findSet(b)) {
    			result = c + 1;
    			break;
    		}
    		
    		union(a, b);
    	}
    	
    	System.out.println(result);
    	
    }
	static void makeSet() {
		for(int i = 0; i < n; i++) {
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