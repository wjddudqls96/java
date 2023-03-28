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
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}
		
		int result = 0;
		
		int cnt = 0;
		max = Integer.MIN_VALUE;
		visited = new boolean[N][N];
		dfs(0, 0, cnt);
		result += max;
		
		cnt = 0;
		max = Integer.MIN_VALUE;
		visited = new boolean[N][N];
		dfs(1, 0, cnt);
		result += max;
		
		System.out.println(result);
	}
	
	static void dfs(int startX, int startY, int count) {
		
		if(max < count) {
			max = count;
		}
		
		
		if(startX >= N) {
			startY++;
			if(startX % 2 == 0) {
				startX = 1;
			}
			else {
				startX = 0;
			}
		}
		
		if(startY >= N) {
			return;
		}
		
		if(isPossible(startX, startY) && map[startY][startX] == 1) {
			visited[startY][startX] = true;
			dfs(startX + 2, startY, count + 1);
			visited[startY][startX] = false;
		}
		
		dfs(startX + 2, startY, count);
	}
	
	static boolean isPossible(int startX, int startY) {
		
		for(int i = 0; i < 4; i++) {
			int nextX = startX + directions[i][0];
			int nextY = startY + directions[i][1];
			
			for(int j = 0; j < N; j++) {
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) break;
				
				if(visited[nextY][nextX]) return false;
				
				nextX += directions[i][0];
				nextY += directions[i][1];
			}
		}
		
		return true;
	}
}