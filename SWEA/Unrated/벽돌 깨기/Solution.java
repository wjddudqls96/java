package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	int num;
	
	Pos(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class Main {
	static int N, H, W, MIN;
	static int[] input;
	static int[][] map, temp;
	static Queue<Pos> queue;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			input = new int[N];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			MIN = Integer.MAX_VALUE;
			
			permutation(0);
			
			sb.append("#" + t + " " + MIN).append("\n");
		}
		System.out.println(sb);
	}
	
	static void permutation(int cnt) {
		if(cnt == N) {
			copyTemp();
			
			for(int i = 0; i < input.length; i++) {
				int x = input[i];
				int y = H - 1;
				queue = new ArrayDeque<>();
				
				for(int j = 0; j < H; j++) {
					if(temp[j][x] != 0) {
						queue.offer(new Pos(x, j, temp[j][x]));
						break;
					}
				}

				while(!queue.isEmpty()) {
					Pos pos = queue.poll();
					breakBlock(pos.x, pos.y, pos.num);
				}
				dropBlock();
			}
			
			int count = 0;
			for(int[] m : temp) {
				for(int num : m) {
					if(num != 0) {
						count++;
					}
				}
			}
			
			if(MIN > count) {
				MIN = count;
			}
			
			return;
		}
		
		for(int i = 0; i < W; i++) {
			input[cnt] = i;
			permutation(cnt +1);
		}
	}
	
	static void copyTemp() {
		temp = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			temp[i] = Arrays.copyOf(map[i], map[i].length);
		}
	}
	
	static void dropBlock() {
		for(int i = 0; i < W; i++) {
			boolean isFirst = false;
			Queue<Integer> q = new ArrayDeque<>();
			int startY = -1;
			
			for(int j = H - 1; j >= 0; j--) {
				if(isFirst && temp[j][i] != 0) {
					q.offer(temp[j][i]);
				}
				
				if(!isFirst && temp[j][i] == 0) {
					isFirst = true;
					startY = j;
				}
			}
			
			for(int j = startY; j >= 0; j--) {
				int num = 0;
				
				if(!q.isEmpty()) {
					num = q.poll();
				}
				
				temp[j][i] = num;
			}
		}
	}
	
	static void breakBlock(int x, int y, int num) {
		// 위 0 으로 만들기.
		int ty = y;
		for(int i = 0; i < num; i++) {
			if(ty >= 0) {
				if(temp[ty][x] > 1) {
					queue.offer(new Pos(x, ty, temp[ty][x]));
				}
				temp[ty][x] = 0;
				ty--;
			}
		}
		// 아래.
		ty = y;
		for(int i = 0; i < num; i++) {
			if(ty < H) {
				if(temp[ty][x] > 1) {
					queue.offer(new Pos(x, ty, temp[ty][x]));
				}
				temp[ty][x] = 0;
				ty++;
			}
		}
		
		// 왼.
		int tx = x;
		for(int i = 0; i < num; i++) {
			if(tx >= 0) {
				if(temp[y][tx] > 1) {
					queue.offer(new Pos(tx, y, temp[y][tx]));
				}
				temp[y][tx] = 0;
				tx--;
			}
		}
		
		// 오.
		tx = x;
		for(int i = 0; i < num; i++) {
			if(tx < W) {
				if(temp[y][tx] > 1) {
					queue.offer(new Pos(tx, y, temp[y][tx]));
				}
				temp[y][tx] = 0;
				tx++;
			}
		}
	}
}
