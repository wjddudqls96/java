import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	
    	int K = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	
    	long[] arr = new long[K];
    	long max = 0;
    	
    	for(int i = 0; i < K; i++) {
    		arr[i] = Long.parseLong(in.readLine());
    		max = Math.max(max, arr[i]);
    	}
    	
    	long min = 1;
    	
    	while(min <= max) {
    		
    		long mid = (min + max) / 2;
    		int sum = 0;
    		
    		for(int i = 0; i < K; i++) {
    			sum += arr[i] / mid;
    		}
    		
    		if(sum >= N) {
    			min = mid + 1;
    		}
    		else {
    			max = mid - 1;
    		}
    	}
    	
    	System.out.println(max);
    }
}