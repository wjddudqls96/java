import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] V,W;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		V = new int[N + 1];
		W = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N + 1][K + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				 	dp[i][j] = dp[i-1][j];     // 이전 행 결과 복사
	                if(j - W[i]>=0) {    // 무게가 남으면
	                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-W[i]]+V[i]); // 더 큰 값으로 갱신
	                }
			}
		}
		
		System.out.println(dp[N][K]);
	}
}