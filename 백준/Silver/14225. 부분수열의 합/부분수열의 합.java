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
	static String S;
	static int[] arr;
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	S = in.readLine();
    	st = new StringTokenizer(S);
    	arr = new int[N];
    	list = new ArrayList<>();
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	bitSubSet();
    	Collections.sort(list);
 
    	int result = 0;
    	
    	for(int i = 0; i < list.size(); i++) {
    		int num = list.get(i);
    		
    		if(result + 1 == num) {
    			result++;
    		}
    		else if(result != num) {
    			break;
    		}
    	}
    	
    	System.out.println(result + 1);
    }
	
	static void bitSubSet() {
		for(int i = 0; i < 1 << N; i++) {
			int sum = 0;
			
			for(int j = 0; j < N; j++) {
				if((1 & i >> j) == 0) continue;
				
				sum += arr[j];
			}
			
			if(sum == 0) continue;
			
			list.add(sum);
		}
	}
}