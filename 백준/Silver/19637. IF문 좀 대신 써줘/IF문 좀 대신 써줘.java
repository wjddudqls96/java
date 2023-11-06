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

class Named implements Comparable<Named>{
	String name;
	int interval;
	
	public Named(String name, int interval) {
		this.name = name;
		this.interval = interval;
	}
	
	@Override
	public int compareTo(Named o1) {
		return this.interval - o1.interval;
	}

	@Override
	public String toString() {
		return "Named [name=" + name + ", interval=" + interval + "]";
	}
	
	
}


public class Main {
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	List<Named> list = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    
    		String name = st.nextToken();
    		int interval = Integer.parseInt(st.nextToken());
    		
    		list.add(new Named(name, interval));
    	}
    	
    	for(int i = 0; i < M; i++) {
    		int num = Integer.parseInt(in.readLine());
    		// 이분 탐색 시작
    		int left = 0;
    		int right = list.size() - 1;
    		
    		while(left <= right) {
    			int mid = (left + right) / 2;
    			
    			if(num <= list.get(mid).interval) {
    				right = mid - 1;
    			}
    			else {
    				left = mid + 1;
    			}
    		}
    		
    		sb.append(list.get(left).name).append("\n");
    	}
    	
    	System.out.println(sb);
    }
}