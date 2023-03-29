import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
	static int N, max;
	static int[][] map;
	static boolean[][] visited;
	static int[][] directions = {{1, -1},{1, 1},{-1, 1},{-1, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] DP = new int[N][N][3];
		
		if(map[0][2] != 1) {
			DP[0][2][0] = 1;
			DP[0][2][1] = 0;
			DP[0][2][2] = 0;
		}
		
		if(map[1][2] != 1 && map[0][2] != 1 && map[1][1] != 1) {
			DP[1][2][0] = 0;
			DP[1][2][1] = 1;
			DP[1][2][2] = 0;
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 2; j < N; j++) {
				if(map[i][j] == 1) continue;
				
				if(i == 1 && j == 2) continue;
				// 가로로 왔을때
				if(j - 1 >= 0) {
					if(map[i][j - 1] != 1) {
						DP[i][j][0] += DP[i][j - 1][0] + DP[i][j - 1][1];
					}
					
				}
				
				// 대각으로 왔을때
				if(j - 1 >= 0 && i - 1 >= 0) {
					if(map[i - 1][j - 1] != 1 && map[i - 1][j] != 1 && map[i][j - 1] != 1) {
						DP[i][j][1] = DP[i - 1][j - 1][0] + DP[i - 1][j - 1][1] + DP[i - 1][j - 1][2];
					}
					
				}
				
				// 세로로 왔을때
				if(i - 1 >= 0) {
					if(map[i - 1][j] != 1) {
						DP[i][j][2] = DP[i - 1][j][2] + DP[i - 1][j][1];
					}
					
				}
			}
		}
		
		System.out.println(DP[N - 1][N - 1][0] + DP[N - 1][N - 1][1] + DP[N - 1][N - 1][2]);
	}
}