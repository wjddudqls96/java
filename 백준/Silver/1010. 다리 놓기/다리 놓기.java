import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, R;
	static int[] bridge;
	static int count = 0;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			dp = new int[30][30];
			System.out.println(combination(N, R));
		}
	}
	
	static int combination(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		
		if(r == 0 || n == r) {
			return dp[n][r] = 1;
		}
		
		return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}
}