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
    static int max =1;
    static long dp[];
    
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	
    	
        dp = new long[101];
        
        
        for(int i = 1; i <= 6; i++) {
            dp[i] = i;
        }
        
        for(int i = 7; i <= N; i++) {
            for(int j = 3; j <= i; j++) {
                long printed = dp[i - j];
                long buf = dp[i - j];
                int v_cnt = j - 2;
                dp[i] = Math.max(dp[i], printed + (buf * v_cnt));
            }
        }
        
        System.out.println(dp[N]);
    }
}