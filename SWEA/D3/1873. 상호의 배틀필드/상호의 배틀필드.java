import java.io.*;
import java.util.*;

class Tank{
	int x;
	int y;
	char direction;
	
	Tank(int x, int y, char direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
}

class Solution {
	static int H,W;
	static Tank tank;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for(int i = 0; i < H; i++) {
				String line = in.readLine();
				for(int j = 0; j < W; j++) {
					char b = line.charAt(j);
					if(b == '<' || b == '>' || b == '^' || b == 'v') {
						tank = new Tank(j, i, b);
						map[i][j] = '.';
					}
					else {
						map[i][j] = b;
					}
				}
			}
			
			int CommandCnt = Integer.parseInt(in.readLine());
			String command = in.readLine();
			
			for(int i = 0; i < command.length(); i++) {
				operation(command.charAt(i));
			}
			map[tank.y][tank.x] = tank.direction;
			
			sb.append("#" + t + " ");
			for(char[] cArr : map) {
				for(char c : cArr) {
					sb.append(c);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void operation(char command) {
		switch (command) {
		case 'U':
			tank.direction = '^';
			if(isMove(tank.x, tank.y - 1)) {
				tank.y -= 1;
			}
			break;
		case 'D':
			tank.direction = 'v';
			if(isMove(tank.x, tank.y + 1)) {
				tank.y += 1;
			}
			break;
		case 'L':
			tank.direction = '<';
			if(isMove(tank.x - 1, tank.y)) {
				tank.x -= 1;
			}
			break;
		case 'R':
			tank.direction = '>';
			if(isMove(tank.x + 1, tank.y)) {
				tank.x += 1;
			}
			break;
		case 'S':
			shoot();
			break;
		}
	}
	
	static boolean isMove(int x, int y) {
		if(x < 0 || x >= W || y < 0 || y >= H || map[y][x] == '-' || map[y][x] == '*' || map[y][x] == '#') {
			return false;
		}
		return true;
	}
	
	static void shoot() {
		char tankDir = tank.direction;
		switch (tankDir) {
		case '^':
			for(int i = tank.y; i >= 0; i--) {
				if(isblock(tank.x, i)) {
					break;
				}
				if(map[i][tank.x] == '*') {
					map[i][tank.x] = '.';
					break;
				}
			}
			break;
		case 'v':
			for(int i = tank.y; i < H; i++) {
				if(isblock(tank.x, i)) {
					break;
				}
				if(map[i][tank.x] == '*') {
					map[i][tank.x] = '.';
					break;
				}
			}
			break;
		case '<':
			for(int i = tank.x; i >= 0; i--) {
				if(isblock(i, tank.y)) {
					break;
				}
				if(map[tank.y][i] == '*') {
					map[tank.y][i] = '.';
					break;
				}
			}
			break;
		case '>':
			for(int i = tank.x; i < W; i++) {
				if(isblock(i, tank.y)) {
					break;
				}
				if(map[tank.y][i] == '*') {
					map[tank.y][i] = '.';
					break;
				}
			}
			break;
	}
	}
	static boolean isblock(int x, int y) {
		if(map[y][x] == '#') {
			return true;
		}
		return false;
	}
}