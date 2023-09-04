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
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[] arr = new int[N];
    	
    	st = new StringTokenizer(in.readLine());
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int count = 0;
    	int sum = 0;
		int end = 0;
		
    	for(int start = 0; start < N; start++) {
    		
    		while(sum < M && end < N) {
    			sum += arr[end++];
    		}
    		
    		if(sum == M) {
    			count++;
    		}
    		
    		sum -= arr[start];
    	}
    	
    	System.out.println(count);
    }
}