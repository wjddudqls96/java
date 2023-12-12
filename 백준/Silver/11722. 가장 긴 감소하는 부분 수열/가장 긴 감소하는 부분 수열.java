import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(in.readLine());
		
		int[] map = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i=1; i<=n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		for (int i=1; i<=n; i++) {
			dp[i] = 1;
			for (int j=1; j<i; j++) {
				if (map[j] > map[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
    }
}