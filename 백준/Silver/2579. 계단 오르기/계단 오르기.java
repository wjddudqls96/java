import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(in.readLine());
    	int[] dp = new int[301];
    	int[] arr = new int[301];
    	
    	
    	for(int i = 1; i <= T; i++) {
    		arr[i] = Integer.parseInt(in.readLine());
    	}
    	
    	
    	dp[1] = arr[1];
    	dp[2] = arr[1] + arr[2];
    	dp[3] = Math.max(arr[1], arr[2]) + arr[3];
    	
    	for(int i = 4; i <= T; i++) {
    		dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
    	}
    	
    	System.out.println(dp[T]);
    }
}