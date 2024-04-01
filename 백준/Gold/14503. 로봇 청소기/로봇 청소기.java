import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


// 북쪽 0, 동쪽 1, 남쪽 2, 서쪽 3 = 4 - current - 1

class Robot {
	int x;
	int y;
	int dir;
	
	public Robot(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}


public class Main {
	private static int N, M, R, C, D;
	private static int[][] map;
	private static Robot robot;
	private static final int DONE_CLEANING = 2;
	private static final int STOP_ROBOT = 1;
	private static final int KEEP_GOING = 0;
	private static int[][] dir = {{0, -1},{1, 0},{0, 1},{-1, 0}};
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		robot = new Robot(C, R, D);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for(int j = 0; j < M; j++) {
				int number = Integer.parseInt(st.nextToken());
				
				map[i][j] = number;
			}
		}
		

		
		int isContinue = KEEP_GOING;
		
		while(isContinue == KEEP_GOING) {
			step1();
			
			if(!isExistNotCleaning()) {
				isContinue = step2();
			}
			else {
				step3();
			}
		}
		
		int result = 0;
		
		for(int[] arr : map) {
			
			for(int n : arr) {
				if(n == 2) {
					result++;
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	// 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
	static void step1() {
		if(map[robot.y][robot.x] == 0) {
			map[robot.y][robot.x] = DONE_CLEANING;
		}
	}
	
	static boolean isExistNotCleaning() {
		int count = 0;
		
		for(int i = 0; i < 4; i++) {
			int nextX = robot.x + dir[i][0];
			int nextY = robot.y + dir[i][1];
			
			if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) continue;
			
			if(map[nextY][nextX] == 0) count++;
		}
		
		return count > 0 ? true : false;
	}
	
	// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
	static int step2() {
		int nextDir = (robot.dir + 2) % 4;
		int nextX = robot.x + dir[nextDir][0];
		int nextY = robot.y + dir[nextDir][1];
		boolean isPossibleBack = true;
		
		if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || map[nextY][nextX] == 1) {
			isPossibleBack = false;
		}
		
		
		if(isPossibleBack) {
			robot.x = nextX;
			robot.y = nextY;
			return KEEP_GOING;
		}
		else {
			return STOP_ROBOT;
		}
	}
	
	static void step3() {
		robot.dir = (robot.dir - 1 + 4) % 4;
		int nextX = robot.x + dir[robot.dir][0];
		int nextY = robot.y + dir[robot.dir][1];
		
		if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || map[nextY][nextX] != 0) {
			return;
		}
		else {
			robot.x = nextX;
			robot.y = nextY;
		}
	}
}