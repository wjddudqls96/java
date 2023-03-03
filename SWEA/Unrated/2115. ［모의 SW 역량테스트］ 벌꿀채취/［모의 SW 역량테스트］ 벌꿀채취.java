import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	static int N, M, C, max, max2, max3;
	static int[][] map;
	static ArrayList<Pos> clist;
	static int[] input, input2;
	static boolean[][] visited;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			clist = new ArrayList<>();
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < N; j++) {
					if(j + M <= N) {
						clist.add(new Pos(j, i));
					}
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			input = new int[2];
			visited = new boolean[N][N];
			max = Integer.MIN_VALUE;
			permutation(0, 0);
			
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	static void getResult(int index) {
		Pos pos = clist.get(index);
		int x = pos.x;
		int y = pos.y;
		int[] numbers = new int[M];
		
		for(int i = x; i < x + M; i++) {
			numbers[i - x] = map[y][i];
		}
		
		
		isSelected = new boolean[M];
		

		permutation2(0, numbers);
	}
	
	static void permutation2(int cnt, int[] numbers) {
		if(cnt == M) {
			int sum = 0;
			int result = 0;
			for(int i = 0; i < isSelected.length; i++) {
				if(isSelected[i]) {
					if(sum + numbers[i] <= C) {
						sum += numbers[i];
						result += Math.pow(numbers[i], 2);
					}
				}
			}
			
			if(max2 < result) {
				max2 = result;
			}
			return;
		}
		
		isSelected[cnt] = true;
		permutation2(cnt + 1, numbers);
		isSelected[cnt] = false;
		permutation2(cnt + 1, numbers);
	}
	
	static void permutation(int cnt, int start) {
		
		if(cnt == 2) {
			int sum = 0;
			for(int i = 0; i < 2; i++) {
				int index= input[i];
				max2 = Integer.MIN_VALUE;
				getResult(index);
				
				sum += max2;
			}
			
			if(max < sum) {
				max = sum;
			}
			return;
		}
		
		for(int i = start; i < clist.size(); i++) {
			// 겹친다면 다음 걸루
			if(!check(i)) {
				continue;
			}
			input[cnt] = i;
			permutation(cnt + 1, i + 1);
			backVisited(i);
		}
	}
	
	static boolean check(int index) {
		
		Pos pos = clist.get(index);
		int x = pos.x;
		int y = pos.y;
		
		for(int i = x; i < x + M; i++) {
			if(visited[y][i]) {
				return false;
			}
		}
		
		for(int i = x; i < x + M; i++) {
			visited[y][i] = true;
		}
		
		return true;
	}
	
	static void backVisited(int index) {
		Pos pos = clist.get(index);
		int x = pos.x;
		int y = pos.y;
		for(int i = x; i < x + M; i++) {
			visited[y][i] = false;
		}
	}
}