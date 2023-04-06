import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N, INF = Integer.MAX_VALUE/100;
	static int[][] dist, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		dist = new int[N][N];
		dp = new int[1 << N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < (1 << N); i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(tps(1, 0));
		
	}
	
	static int tps(int visited, int city) {
		
		// 마지막 도착지에 도착한다면
		if(visited == ((1 << N) - 1)) {
			// 마지막 도착지에서 처음으로 못되돌아간다면.
			if(dist[city][0] == 0) return INF;
			return dist[city][0];
		}
		
		
		if(dp[visited][city] != -1) {
			return dp[visited][city];
		}
		
		dp[visited][city] = INF;
		
		for(int i = 0; i < N; i++) {
			if((visited & (1 << i)) != 0) continue;
			
			if(dist[city][i] == 0) continue;
			
			int res = tps((visited | (1 << i)), i) + dist[city][i];
			dp[visited][city] = Math.min(res, dp[visited][city]);
		}
		
		return dp[visited][city];
	}
}