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

class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return this.x + " " + this.y;
	}
}

public class Main {
	static int N, K, head;
	static int[][] map;
	static boolean[][] visit;
	static char[] timeTable;
	static Deque<Node> snakes = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("input.txt"));
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	K = Integer.parseInt(in.readLine());
    	
    	map = new int[N][N];
    	visit = new boolean[N][N];
    	snakes.offer(new Node(0, 0));
    	visit[0][0] = true;
    	head = 1;
    	
    	for(int i = 0; i < K; i++) {
    		st = new StringTokenizer(in.readLine());
    		
    		int Y = Integer.parseInt(st.nextToken()) - 1;
    		int X = Integer.parseInt(st.nextToken()) - 1;
    		
    		map[Y][X] = 1;
    	}
    	
    	int step = Integer.parseInt(in.readLine());
    	
    	timeTable = new char[10010];
    	
    	for(int i = 0; i < step; i++) {
    		st = new StringTokenizer(in.readLine());
    		
    		int time = Integer.parseInt(st.nextToken());
    		char dir = st.nextToken().charAt(0);
    		
    		timeTable[time] = dir;
    	}
    	
    	int time = 0;
    	
    	while(true) {
    		time++;
    		
    		boolean isPossible = move();
    		
    		if(!isPossible) break;
    		
    		if(timeTable[time] != '\0') {
    			changeHead(timeTable[time]);
    		}
    	}
    	
    	
    	System.out.println(time);
	}
	
	// 1초에 해당 방향으로 1칸이동.
	static boolean move() {
		int[][] dir = {{0, -1},{1, 0},{0, 1},{-1, 0}};
		
		Node cur = snakes.peekFirst();
		
		int nextX = cur.x + dir[head][0];
		int nextY = cur.y + dir[head][1];
		
		// 만약 범위를 벗어난다면 종료.
		if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) return false;
		
		// 만약 뱀이있는 자리면 종료.
		if(visit[nextY][nextX]) return false;
		
		visit[nextY][nextX] = true;
		snakes.offerFirst(new Node(nextX, nextY));
		
		// 1. 만약 사과가 있다면 (꼬리가 삭제되면 안됨.)
		if(map[nextY][nextX] == 1) {
			map[nextY][nextX] = 0;
		}
		// 2. 만약 사과가 없다면 (꼬리가 삭제되어야함.)
		else if(map[nextY][nextX] == 0) {
			Node last = snakes.pollLast();
			visit[last.y][last.x] = false;
		}
		
		return true;
	}
	
	static void changeHead(char dir) {
		// head 0 위, 1 오른쪽, 2 아래, 3 왼쪽.
		
		// 왼쪽으로 회전.
		if(dir == 'L') {
			head = (head + 3) % 4;
		}
		// 오른쪽으로 회전.
		else if(dir == 'D') {
			head = (head + 1) % 4;
		}
	}
}