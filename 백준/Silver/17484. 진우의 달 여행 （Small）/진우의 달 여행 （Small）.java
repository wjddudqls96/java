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
import java.util.StringTokenizer;

public class Main {
	static int[][] direction = {{0, 1}, {1, 1}, {-1, 1}};
	static int N, M;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			dfs(i, 0, -1, map[0][i]);
		}
		
		System.out.println(min);
	}
	
	public static void dfs(int x, int y, int dir, int sum) {
		
		// 브레이킹 포인트 y값이 끝을 넘어가면 종료
		if(y == N - 1) {
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			int nextX = x + direction[i][0];
			int nextY = y + direction[i][1];
			// 현재 방향과 다르다면 다음 단계로 가도록한다. && 범위에 벗어나면 종료하도록 한다.
			if(i != dir && isPossible(nextX, nextY)) {
				dfs(nextX, nextY, i, sum + map[nextY][nextX]);
			}
		}
	}
	
	public static boolean isPossible(int x, int y) {
		if(N > y && y >= 0 && M > x && x >= 0) {
			return true;
		}
		
		return false;
	}
}