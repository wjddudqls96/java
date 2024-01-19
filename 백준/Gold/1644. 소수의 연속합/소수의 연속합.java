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
	static int N, M;
	static boolean prime[];
	static List<Integer> primeList;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("input.txt"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	
    	primeList = new ArrayList<>();
    	
    	getPrime();
    	
    	// 투포인터를 이용해서 값 구하기. 
    	int left = 0;
    	int right = 0;
    	int result = 0;
    	int sum = 2;
    	
    	while(left < primeList.size() && right < primeList.size()) {
    		
    		if(sum == N) {
    			result++;
    			sum -= primeList.get(left);
    			left++;
    		}
    		else if(sum > N) {
    			sum -= primeList.get(left);
    			left++;
    		}
    		else {
    			right++;
    			if(right >= primeList.size()) break;
    			sum += primeList.get(right);
    		}
    	}
    	
    	System.out.println(result);
        
	}
	
	static void getPrime() {
		prime = new boolean[N + 1];
		
		prime[0] = prime[1] = true;
		
		for(int i = 2; i * i <= N; i++) {
			
			if(!prime[i]) {
				for(int j = i * i; j <= N; j += i) {
					prime[j] = true;
				}
			}
		}
		
		for(int i=1; i<=N;i++){
        	if(!prime[i]) {
        		primeList.add(i);
        	}
        }
	}
}