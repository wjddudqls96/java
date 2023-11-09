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
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(in.readLine());
    	int[] arr = new int[N];
    	int[] cnt = new int[100001];
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int left = 0;
    	int right = 0;
    	int result = 0;
    	
    	while(left <= right) {
    		
    		if(right <= N - 1 && cnt[arr[right]] < M) {
    			cnt[arr[right]]++;
    			right++;
    		}
    		else if(cnt[arr[right]] == M) {
    			cnt[arr[left]]--;
    			left++;
    		}
    		
    		result = Math.max(right - left, result);
    		
    		if(right == N) break;
    	}
    	
    	System.out.println(result);
    }
}