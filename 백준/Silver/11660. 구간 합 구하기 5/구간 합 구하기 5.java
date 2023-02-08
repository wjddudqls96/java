import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		dp = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			String[] line = in.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				sum += Integer.parseInt(line[j-1]);
				if(i == 1) {
					dp[i][j] = sum;
				}
				else {
					dp[i][j] = dp[i - 1][j] + sum;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			String[] line = in.readLine().split(" ");
			
			int x1 = Integer.parseInt(line[0]);
			int y1 = Integer.parseInt(line[1]);
			int x2 = Integer.parseInt(line[2]);
			int y2 = Integer.parseInt(line[3]);

			sb.append(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]).append("\n");
			
			
		}
		
		System.out.println(sb);
	}
}