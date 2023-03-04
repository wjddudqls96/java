import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + "]";
	}
	
	
}

class Solution {
	static int N, sX, sY, max;
	static int[][] map;
	static int[][] visited;
	static int[][] directions = {{1, -1},{1, 1},{-1, 1},{-1, -1}};
	static ArrayList<Integer> list, cafe;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = Integer.MIN_VALUE;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sX = j;
					sY = i;
					visited= new int[N][N];
					list = new ArrayList<>();
					cafe = new ArrayList<>();
					dfs(j, i, 0, 0);
				}
			}
			
			sb.append("#" + t + " ");
			if(max == Integer.MIN_VALUE) {
				sb.append(-1).append("\n");
			}
			else {
				sb.append(max).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int count, int dir) {
		
		if((x == sX && y == sY) && count != 0) {
			HashSet<Integer> set = new HashSet<>(list);
			if(set.size() == 4) {
				if(max < cafe.size()) {
					max = cafe.size();
				}
			}
			return;
		}

		for(int i = dir; i < 4; i++) {
			int nextX = x + directions[i][0];
			int nextY = y + directions[i][1];
			
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextY][nextX] == 1) continue;
			
			if(cafe.contains(map[nextY][nextX])) continue;
			
			count += 1;
			// 오른쪽 위 대각선
			visited[nextY][nextX] = 1;
			list.add(i);
			cafe.add(map[nextY][nextX]);
			dfs(nextX, nextY, count, i);
			count -= 1;
			visited[nextY][nextX] = 0;
			list.remove(count);
			cafe.remove(count);
		}
	}
	
	static boolean isCollectRoute() {
		
		int temp = list.get(0);
		
		for(int i = 1; i < list.size(); i++) {
			int cur = list.get(i);
			if(temp > cur) {
				return false;
			}
			
			temp = cur;
		}
		return true;
	}
}