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
    static int N, M;
    static long[] arr;
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new long[N];
    	
    	long max = 0;
    	
    	for(int i = 0; i < N; i++) {
    		long num = Long.parseLong(in.readLine());
    		arr[i] = num;
    		max = Math.max(max, num);
    	}
    	
    	// 이분탐색 시작.
    	long left = 0;
    	long right = max * M;
    	long result = Long.MAX_VALUE;
    	
    	while(left <= right) {
    		long mid = (left + right) / 2;
    		long sum = 0;
    		
    		for(int i = 0; i < arr.length; i++) {
    			if(sum >= M){
    	            break;
    	        }
    			
    			sum += mid / arr[i] ;
    		}
    		
    		if(sum >= M) {
    			right = mid - 1;
    			result = Math.min(result, mid);
    			continue;
    		}
    		else {
    			left = mid + 1;	
    		}
    	}
    	
    	System.out.println(result);
	}
}