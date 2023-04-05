import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Fish{
	int x;
	int y;
	int dir;
	
	public Fish(int x, int y, int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public void changeDirection() {
		
	}

	@Override
	public String toString() {
		return "Fish [x=" + x + ", y=" + y + ", dir=" + dir + "]";
	}
	
	
}

public class Main {
	static int M, S, MAX;
	static Queue<Fish>[][] map;
	static ArrayList<Fish> initFishes;
	static int[][] smells;
	static Stack<Integer> minRoute;
	static Fish shark;
	static int[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		map = new ArrayDeque[4][4];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				map[i][j] = new ArrayDeque<>();
			}
		}
		
		initFishes = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			
			map[y][x].add(new Fish(x, y, dir));
			initFishes.add(new Fish(x, y, dir));
		}
		
		st = new StringTokenizer(in.readLine());
		
		int sharkY = Integer.parseInt(st.nextToken()) - 1;
		int sharkX = Integer.parseInt(st.nextToken()) - 1;
		
		shark = new Fish(sharkX, sharkY, -1);
		smells = new int[4][4];
		result = new int[3];
		for(int i = 0; i < S; i++) {
			moveFish();
			minRoute = new Stack<>();
			MAX = Integer.MIN_VALUE;
			sharkBacktracking(shark, 0);
			moveShark(minRoute);
			removeSmell();
			copyFish();
		}
		
		int cnt = 0;
		for(Queue[] m : map) {
			for(Queue q : m) {
				cnt += q.size();
			}
		}
		
		System.out.println(cnt);
	}
	
	static void copyFish() {
		for(int i = 0; i < initFishes.size(); i++) {
			Fish fish = initFishes.get(i);
			map[fish.y][fish.x].offer(fish);
		}
		
		initFishes = new ArrayList<>();
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(Fish fish : map[i][j]) {
					initFishes.add(new Fish(fish.x, fish.y, fish.dir));
				}
			}
		}
	}
	
	static void removeSmell() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(smells[i][j] != 0) {
					smells[i][j]--;
				}
			}
		}
	}
	
	static void moveShark(Stack<Integer> stack) {
		int[][] directions = {{0, -1},{-1, 0},{0, 1},{1, 0}}; // 1, 2, 3, 4
		
		int x = shark.x;
		int y = shark.y;
		
		ArrayList<Integer> list = new ArrayList<>(stack);
		for(int i = 0; i < list.size(); i++) {
			int dir = list.get(i) - 1;
			x += directions[dir][0];
			y += directions[dir][1];
			
			while(!map[y][x].isEmpty()) {
				map[y][x].poll();
				// 냄새 남기기
				smells[y][x] = 3;
			}
		}
		
		shark.x = x;
		shark.y = y;
	}
	
	static void moveFish() {
		// 1 : 왼쪽 , 2 : 대각 왼쪽 위 , 3 : 위 , 4 : 오른쪽 대각 위, 5 : 오른쪽 : 6 : 오른쪽 대각 아래 , 7 : 아래 , 8 : 왼쪽 대각 아래
		int[][] directions = {{-1, 0},{-1, -1},{0, -1},{1, -1},{1, 0},{1, 1},{0, 1},{-1, 1}};
		
		Queue<Fish> queue = new ArrayDeque<>();
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				while(!map[i][j].isEmpty()) {
					queue.offer(map[i][j].poll());
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Fish fish = queue.poll();
			boolean flag = false;
			
			for(int d = 0; d <= 8; d++) {
				int dir = fish.dir - d;
				if(dir < 0) {
					dir = 8 + dir;
				}
				int nextX = fish.x + directions[dir][0];
				int nextY = fish.y + directions[dir][1];
				
				if(nextX < 0 || nextY < 0 || nextX >= 4 || nextY >= 4) continue;
				
				if(smells[nextY][nextX] != 0) continue;
				
				if(nextX == shark.x && nextY == shark.y) continue;
				
				flag = true;
				fish.x = nextX;
				fish.y = nextY;
				fish.dir = dir;
				map[nextY][nextX].offer(fish);
				break;
			}
			
			if(!flag) {
				map[fish.y][fish.x].offer(fish);
			}
		}
	}
	
	private static void sharkBacktracking(Fish shark, int idx) { // 상어 이동방향 정하기 by 중복순열
		int[][] directions = {{0, -1},{-1, 0},{0, 1},{1, 0}}; // 1, 2, 3, 4
		
		if (idx == 3) {
			boolean[][] selected = new boolean[4][4];
			int eatCnt = 0;
			
			int nextX = shark.x;
			int nextY = shark.y;
			
			for(int i = 0; i < result.length; i++) {
				nextX += directions[result[i] - 1][0];
				nextY += directions[result[i] - 1][1];
				
				if(nextX < 0 || nextX >= 4 || nextY < 0 || nextY >= 4) {
					eatCnt = -1;
					break;
				}
				
				if(selected[nextY][nextX]) continue;
				
				eatCnt += map[nextY][nextX].size();
				selected[nextY][nextX] = true;
			}
			
			if(MAX < eatCnt) {
				MAX = eatCnt;
				minRoute = new Stack<>();
				for(int i = 0; i < result.length; i++) {
					minRoute.push(result[i]);
				}
			}
			else if(MAX == eatCnt) {
				String s1 = "";
				String s2 = "";
				
				for(int i = 0; i < result.length; i++) {
					s2 += Integer.toString(result[i]);
				}
				
				for(int i = 0; i < minRoute.size(); i++) {
					s1 += Integer.toString(minRoute.get(i));
				}
				
				if(Integer.parseInt(s1) > Integer.parseInt(s2)) {
					MAX = eatCnt;
					minRoute = new Stack<>();
					for(int i = 0; i < result.length; i++) {
						minRoute.push(result[i]);
					}
				}
			}
			return;
		}

		for (int i = 1; i <= 4; i++) { // 1~4까지 중복순열
			result[idx] = i;
			sharkBacktracking(shark, idx + 1);
		}

	}
}