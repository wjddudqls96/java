import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Ball{
	int x;
	int y;
	int dir;
	
	Ball(int x, int y, int dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

class WormHall{
	int x;
	int y;
	
	public WormHall(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "WormHall [x=" + x + ", y=" + y + "]";
	}
}

class Solution {
	static int N, count, sX, sY, max;
	static int[][] map;
	static int[][] directions = {{0, -1},{1, 0},{0, 1},{-1, 0}};
	static HashMap<Integer, ArrayList<WormHall>> worm;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine().trim()); // 테케
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine().trim());
			
			map = new int[N][N];
			worm = new HashMap<>();
			max = Integer.MIN_VALUE;
			
			for(int i = 6; i < 11; i++) {
				worm.put(i, new ArrayList<>());
			}
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine().trim());
				for(int j = 0; j < N; j++) {
					int type = Integer.parseInt(st.nextToken().trim());
					// 웜홀 만들기.
					if(type >= 6) {
						worm.get(type).add(new WormHall(j, i));
					}
					
					map[i][j] = type;
				}
			}
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 0) {
						for(int k = 0; k < 4; k++) {
							count = 0;
							sX = j;
							sY = i;
							Ball ball = new Ball(j, i, k);
							while(true) {
								startBounce(ball);
								// 게임 종료
								if(map[ball.y][ball.x] == -1 || (ball.x == sX && ball.y == sY)) {
									break;
								}
								// 웜홀 이동! 집어넣기!
								ifWormGo(ball);
							}
							
							if(max < count) {
								max = count;
							}
						}
					}
				}
			}
			if(max == Integer.MIN_VALUE) {
				sb.append("#" + t + " " + 0).append("\n");
			}
			else {
				sb.append("#" + t + " " + max).append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}
	
	static void ifWormGo(Ball ball) {
		int number = map[ball.y][ball.x];
		
		if(number < 6) return;
		
		ArrayList<WormHall> list = worm.get(number);
		
		for(WormHall w : list) {
			if(w.x == ball.x && w.y == ball.y) {
				continue;
			}
			else {
				ball.x = w.x;
				ball.y = w.y;
				break;
			}
		}
	}
	
	static void startBounce(Ball ball) {
		int nextX = ball.x + directions[ball.dir][0];
		int nextY = ball.y + directions[ball.dir][1];
		
		
		if(touchWall(nextX, nextY)) {
			count++;
			ball.dir = (ball.dir + 2) % 4;
			if(turnBlock(ball, map[ball.y][ball.x])) count++;
			return;
		}
		
		int type = map[nextY][nextX];
		
		if(turnBlock(ball, type)) {
			count++;
		}
		
		
		ball.x = nextX;
		ball.y = nextY;
		
		
	}
	
	static boolean touchWall(int x, int y) {
		
		if(x < 0 || x >= N || y < 0 || y >= N) return true;
		
		return false;
	}
	
	static boolean turnBlock(Ball ball, int type) {
		switch (type) {
		case 1:
			turnBall(ball, 2, 3, 1, 0);
			return true;
		case 2:
			turnBall(ball, 1, 3, 0, 2);
			return true;
		case 3:
			turnBall(ball, 3, 2, 0, 1);
			return true;
		case 4:
			turnBall(ball, 2, 0, 3, 1);
			return true;
		case 5:
			turnBall(ball, 2, 3, 0, 1);
			return true;
		default:
			return false;
		}
	}
	
	static void turnBall(Ball ball, int up, int right, int down, int left) {
		if(ball.dir == 0) {
			ball.dir = up;
		}
		else if(ball.dir == 1) {
			ball.dir = right;
		}
		else if(ball.dir == 2) {
			ball.dir = down;
		}
		else if(ball.dir == 3) {
			ball.dir = left;
		}
	}
}