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
	static int N, S;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("input.txt"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(in.readLine());
    	
    	arr = new int[N];
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
        
    	int left = 0;
    	int right = 0;
    	int sum = arr[0];
    	int min = Integer.MAX_VALUE;
    	
    	while(left < N && right < N) {
    		
    		if(sum >= S) {
    			
    			min = Math.min(min, right - left + 1);
    			
    			sum -= arr[left];
    			left++;
    		}
    		else {
    			right++;
    			
    			if(right >= N) break;
    			
    			sum += arr[right];
    		}
    	}
    	
    	if(min == Integer.MAX_VALUE) {
    		System.out.println(0);
    	}
    	else {
    		System.out.println(min);
    	}
	}
}