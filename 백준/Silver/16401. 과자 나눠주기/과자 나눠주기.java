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
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    static int N,M;
    static int[] arr;
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[M];
    	
    	st = new StringTokenizer(in.readLine());
    	
    	for(int i = 0; i < M; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	// 2분 탐색 시작.
    	
    	long low = 1;
    	long high = arr[arr.length - 1];
    	long result = 0;
    	
    	while(low <= high) {
    		int count = 0;
    		long mid = (low + high) / 2;
    		
    		for(int i = 0; i < M; i++) {
    			count += arr[i] / mid;
    		}
    		
    		if(count >= N) {
    			result = Math.max(result, mid);
    			low = mid + 1;
    		}
    		else {
    			high = mid - 1;
    		}
    	}
    	
    	System.out.println(result);
    }
	
}