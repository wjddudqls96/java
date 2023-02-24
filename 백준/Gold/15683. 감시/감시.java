import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	int type;
	
	Pos(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
}
public class Main {
	static int N, M;
	static ArrayList<Pos> cctvList;
	static int[][] direction = {{0, -1},{1, 0},{0, 1},{-1, 0}};
	static int[][] map, copy;
	static int[] input;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		cctvList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num != 0 && num != 6) {
					cctvList.add(new Pos(j, i, num));
				}
				map[i][j] = num;
			}
		}
		
		input = new int[cctvList.size()];
		permutation(0);
		System.out.println(min);
	}
	
	static void permutation(int cnt) {
		if(cnt == cctvList.size()) {
			copy = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				copy[i] = Arrays.copyOf(map[i], map[i].length);
			}
			
			for(int i = 0; i < cctvList.size(); i++) {
				Pos pos = cctvList.get(i);
				int turn = input[i];
				
				show(pos, turn);
			}
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(copy[i][j] == 0) {
						count++;
					}
				}
			}
			
			if(min > count) {
				min = count;
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			input[cnt] = i;
			permutation(cnt + 1);
		}
	}
	
	static void show(Pos pos, int turn) {
		int type = pos.type;
		int x = pos.x;
		int y = pos.y;
		switch (type) {
		case 1:
			while(true) {
				int num = (1 + turn) % 4;
				x += direction[num][0];
				y += direction[num][1];
				
				if(x < 0 || x >= M || y < 0 || y >= N || copy[y][x] == 6) break;
				
				copy[y][x] = -1;
			}
			break;
		case 2:
			for(int i = 1; i < 4; i += 2) {
				x = pos.x;
				y = pos.y;
				while(true) {
					int num = (i + turn) % 4;
					x += direction[num][0];
					y += direction[num][1];
					
					if(x < 0 || x >= M || y < 0 || y >= N || copy[y][x] == 6) break;
					
					copy[y][x] = -1;
				}
			}
			
			break;
		case 3:
			for(int i = 0; i < 2; i++) {
				x = pos.x;
				y = pos.y;
				while(true) {
					int num = (i + turn) % 4;
					x += direction[num][0];
					y += direction[num][1];
					
					if(x < 0 || x >= M || y < 0 || y >= N || copy[y][x] == 6) break;
					
					copy[y][x] = -1;
				}
			}
			break;
		case 4:
			for(int i = 0; i < 2; i++) {
				x = pos.x;
				y = pos.y;
				while(true) {
					int num = (i + turn) % 4;
					x += direction[num][0];
					y += direction[num][1];
					
					if(x < 0 || x >= M || y < 0 || y >= N || copy[y][x] == 6) break;
					
					copy[y][x] = -1;
				}
			}
			x = pos.x;
			y = pos.y;
			while(true) {
				int num = (3 + turn) % 4;
				x += direction[num][0];
				y += direction[num][1];
				
				if(x < 0 || x >= M || y < 0 || y >= N || copy[y][x] == 6) break;
				
				copy[y][x] = -1;
			}
			break;
		case 5:
			for(int i = 0; i < 4; i++) {
				x = pos.x;
				y = pos.y;
				while(true) {
					int num = (i + turn) % 4;
					x += direction[num][0];
					y += direction[num][1];
					
					if(x < 0 || x >= M || y < 0 || y >= N || copy[y][x] == 6) break;
					
					copy[y][x] = -1;
				}
			}
			break;
		}
	}
}