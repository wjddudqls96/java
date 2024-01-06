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
    static int N;
    static int[] arr;
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	arr = new int[N];
    	st = new StringTokenizer(in.readLine());
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	int count = Integer.parseInt(in.readLine());
    	st = new StringTokenizer(in.readLine());
    	
    	for(int i = 0; i < count; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		
    		sb.append(getUpperBound(num) - getLowerBound(num) + " ");
    	}
    	
    	System.out.println(sb);
    }
	
	static int getLowerBound(int key) {
		int low = 0;
		int high = arr.length;
		
		while(low < high) {
			int mid = (low + high) / 2;
			
			if(key <= arr[mid]) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		
		return low;
	}
	
	static int getUpperBound(int key) {
		int low = 0;
		int high = arr.length;
		
		while(low < high) {
			int mid = (low + high) / 2;
			
			if(key < arr[mid]) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}
		
		return low;
	}
	
}