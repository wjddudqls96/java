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
    	
    	arr = new int[N];
    	
    	st = new StringTokenizer(in.readLine());
    	
    	int left = 1;
    	int right = -1;
    	int result = 0;
    	
    	for(int i = 0; i < N; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		arr[i] = num;
    		right = Math.max(right, num);
    	}
    	
    	while(left <= right) {
    		int mid = (left + right) / 2;
    		long sum = 0;
    		
    		for(int i = 0; i < N; i++) {
    			
    			long num = arr[i] - mid;
    			
    			if(num > 0) {
    				sum += num;
    			}
    		}
    		
    		// 만약 나머지 길이들의 합이 원하는 값보다 크다면. 
    		if(sum >= M) {
    			result = Math.max(result, mid);
    			left = mid + 1;
    		}
    		else {
    			right = mid - 1;
    		}
    	}
    	
    	System.out.println(result);
    }
	
}