import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		dp = new int[N];
		String[] line = in.readLine().split(" ");
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(line[i]);
			dp[i] += sum;
		}
		
		for(int i = 0; i < M; i++) {
			String[] line2 = in.readLine().split(" ");
			int a = Integer.parseInt(line2[0]);
			int b = Integer.parseInt(line2[1]);
			
			sb.append(dp[b - 1] - dp[a - 1] + Integer.parseInt(line[a - 1])).append("\n");
		}
		
		System.out.println(sb);
	}
}