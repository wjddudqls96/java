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

class Dice {
	int[] positions;
	
	public Dice() {
		this.positions = new int[7];
	}
	
	public void move(int dir) {
		// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.
		int temp;
		switch(dir) {
			case 1 :
				temp = this.positions[6];
				this.positions[6] = this.positions[3];
				this.positions[3] = this.positions[1];
				this.positions[1] = this.positions[4];
				this.positions[4] = temp;
				break;
			case 2 :
				temp = this.positions[4];
				this.positions[4] = this.positions[1];
				this.positions[1] = this.positions[3];
				this.positions[3] = this.positions[6];
				this.positions[6] = temp;
				break;
			case 3 :
				temp = this.positions[1];
				this.positions[1] = this.positions[5];
				this.positions[5] = this.positions[6];
				this.positions[6] = this.positions[2];
				this.positions[2] = temp;
				break;
			case 4 :
				temp = this.positions[1];
	            this.positions[1] = this.positions[2];
	            this.positions[2] = this.positions[6];
	            this.positions[6] = this.positions[5];
	            this.positions[5] = temp;
				break;
		}
	}
}

public class Main {
	static int N, M, X, Y, K;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		st = new StringTokenizer(in.readLine());
		
		Dice dice = new Dice();
		
		int[][] dirs = {{0, 0},{1, 0},{-1, 0},{0, -1},{0, 1}};
		
		for(int i = 0; i < K; i++) {
			// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로 주어진다.
			int command = Integer.parseInt(st.nextToken());
			
			int nextX = X + dirs[command][0];
			int nextY = Y + dirs[command][1];
			
			if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
			
			dice.move(command);
			
			if(map[nextY][nextX] == 0) {
				map[nextY][nextX] = dice.positions[6];
			}
			else {
				dice.positions[6] = map[nextY][nextX];
				map[nextY][nextX] = 0;
			}
			
			X = nextX;
			Y = nextY;
			
			sb.append(dice.positions[1]).append("\n");
		}
		
		System.out.println(sb);
		
		// 
	}

	
}