import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[][] map, map2;
	static int[][] points;
	static boolean[] visited;
	static int[] input;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		points = new int[K][4];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			points[i][0] = r - s - 1;
			points[i][1] = c - s - 1;
			points[i][2] = r + s - 1;
			points[i][3] = c + s - 1;
		}
		
		visited = new boolean[K];
		input = new int[K];
		permutation(0);
		
		System.out.println(min);
	}
	
	static void permutation(int cnt) {
		if(cnt == K) {
			map2 = new int[N][M];
			copy(map2, map);
			for(int i = 0; i <input.length; i++) {
				rotation(points[input[i]]);
			}
			
			for(int[] row : map) {
				int sum = 0;
				for(int num : row) {
					sum += num;
				}
				if(min > sum) {
					min = sum;
				}
			}
			
			copy(map, map2);
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			input[cnt] = i;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
	
	static void rotation(int[] points) {
		int size = points[3] - points[1] + 1;
		int cycle = (size / 2) + (size % 2);
		
		for(int r = 0; r < cycle; r++) {
			int x = points[1] + r;
			int y = points[0] + r;
			int save = map[y][x];
			int gap = size - 2*r;
			int temp = -1;
			
			if(gap == 1) break;
			
			for(int i = 1; i < gap; i++) {
				x++;
				temp = map[y][x];
				map[y][x] = save;
				save = temp;
			}
			
			for(int i = 1; i < gap; i++) {
				y++;
				temp = map[y][x];
				map[y][x] = save;
				save = temp;
			}
			
			for(int i = 1; i < gap; i++) {
				x--;
				temp = map[y][x];
				map[y][x] = save;
				save = temp;
			}
			
			for(int i = 1; i < gap; i++) {
				y--;
				temp = map[y][x];
				map[y][x] = save;
				save = temp;
			}
			
		}
		
	}
	
	static void copy(int[][] copy, int[][] target) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[i][j] = target[i][j];
			}
		}
	}
}