import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Cell{
	int x;
	int y;
	
	public Cell(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int N, Min, Max;
	static int[][] map;
	static ArrayList<Cell> cells;
	static int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			
			map = new int[N][N];
			cells = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
					
					if(i != 0 && j != 0 && i != N -1 && j != N - 1 && num == 1) {
						cells.add(new Cell(j, i));
					}
				}
			}
			
			Min = Integer.MAX_VALUE;
			Max = Integer.MIN_VALUE;
			dfs(0, 0, 0);
			sb.append("#" + t + " " + Min + "\n");
		}
		System.out.println(sb);
		
	}
	
	static void dfs(int sum, int cnt, int connectCnt) {
		
		if(cnt == cells.size()) {
			if(Max < connectCnt) {
				Max = connectCnt;
				Min = sum;
			}
			else if(Max == connectCnt) {
				if(Min > sum) {
					Min = sum;
				}
			}
			return;
		}
		
		
		Cell cell = cells.get(cnt);
		
		for(int i = 0; i < 4; i++) {
			int count = isPossible(cell.x, cell.y, i);
			
			
			int nx = cell.x;
			int ny = cell.y;
			
			for(int j = 0; j < count; j++) {
				nx += directions[i][0];
				ny += directions[i][1];
				map[ny][nx] = 1;
			}
			
			if(count != -1) {
				dfs(sum + count, cnt + 1, connectCnt + 1);
				
				nx = cell.x;
				ny = cell.y;
				for(int j = 0; j < count; j++) {
					nx += directions[i][0];
					ny += directions[i][1];
					map[ny][nx] = 0;
				}
			}
			else {
				dfs(sum, cnt + 1, connectCnt);
			}
		}
	}
	
	static int isPossible(int x, int y, int dir) {
		int cnt = 0;
		
		while(true) {
			x += directions[dir][0];
			y += directions[dir][1];
			
			if(x < 0 || x >= N || y < 0 || y >= N) {	
				break;
			}
			
			if(map[y][x] == 1) return -1;
			
			cnt++;
		}
		
		return cnt;
	}
}