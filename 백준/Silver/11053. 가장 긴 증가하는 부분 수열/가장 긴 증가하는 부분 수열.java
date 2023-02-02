import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(in.readLine());
    	
    	int[] dp = new int[T];
    	int[] arr = new int[T];
    	String[] split = in.readLine().split(" ");
    	
    	
    	for(int i = 0; i < T; i++) {
    		arr[i] = Integer.parseInt(split[i]);
    	}
    	
    	for(int i = 0; i < T; i++) {
    		dp[i] = 1;
    		
    		for(int j = 0; j < i; j++) {
    			if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
    				dp[i] = dp[j] + 1;
    			}
    		}
    	}
    	
    	int max = Integer.MIN_VALUE;
    	
    	for(int n : dp) {
    		if(max < n) {
    			max = n;
    		}
    	}
    	
    	System.out.println(max);
    }
}