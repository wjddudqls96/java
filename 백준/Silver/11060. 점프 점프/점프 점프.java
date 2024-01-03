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
	static int N;
	static int[] arr;
	static boolean[] possible;
	
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	arr = new int[N];
    	possible = new boolean[N];
    	
    	st = new StringTokenizer(in.readLine());
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	// DP 로직 시작.
    	int[] DP = new int[N];
    	possible[0] = true;
    	
    	for(int i = 0; i < N; i++) {
    		int step = arr[i];
    		
    		if(!possible[i]) continue;
    		
    		for(int j = 1; j <= step; j++) {
    			int next = i + j;
    			
    			if(next < N) {
    				possible[next] = true;
    				
    				if(DP[next] != 0) {
    					DP[next] = Math.min(DP[next], DP[i] + 1);
    				}
    				else {
    					DP[next] = DP[i] + 1;
    				}
    			}
    		}
    	}
    	
    	if(DP[N - 1] == 0) {
    		if(N == 1) {
    			System.out.println(0);
    		}
    		else {
    			System.out.println(-1);
    		}
    	}
    	else {
    		System.out.println(DP[N - 1]);
    	}
    }
}