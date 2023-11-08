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
    	
    	int N = Integer.parseInt(in.readLine());
    	int[] arr = new int[N];
    	
    	st = new StringTokenizer(in.readLine());
    	
    	for(int h = 1; h <= N; h++) {
    		int leftNum = Integer.parseInt(st.nextToken());
    		
    		for(int i = 0; i < N; i++) {
    			
    			if(leftNum == 0 && arr[i] == 0){
    				arr[i] = h;
    				break;
    			}
    			else if(arr[i] > h || arr[i] == 0) {
    				leftNum--;
    			}
    		}
    	}
    	
    	for(int i = 0; i < N; i++) {
    		sb.append(arr[i] + " ");
    	}
    	
    	System.out.println(sb);
    }
}