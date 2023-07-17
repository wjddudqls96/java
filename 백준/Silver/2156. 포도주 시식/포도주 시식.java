import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(in.readLine());
        }
        
        dp[0] = arr[0];
       
        for(int i = 1; i < N; i++) {
        	if(i == 1) {
        		dp[1] = arr[0] + arr[1]; 
        		continue;
        	}
        	if(i == 2) {
        		dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
        		continue;
        	}
        	dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }
       
        
        System.out.println(dp[N - 1]);
    }
    
}