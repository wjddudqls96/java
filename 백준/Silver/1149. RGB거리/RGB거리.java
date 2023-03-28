import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(in.readLine());
		int[][] DP = new int[N][3];
		
		// 0 Red, 1 Green, 2 Blue
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			
			for(int j = 0; j < 3; j++) {
				DP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// start
		for(int i = 1; i < N; i++) {
			// Red
			DP[i][0] += Math.min(DP[i - 1][1], DP[i - 1][2]);
			// Green
			DP[i][1] += Math.min(DP[i - 1][0], DP[i - 1][2]);
			// Blue
			DP[i][2] += Math.min(DP[i - 1][0], DP[i - 1][1]);
		}
		
		System.out.println(Math.min(Math.min(DP[N - 1][0], DP[N - 1][1]), DP[N - 1][2]));
	}
}