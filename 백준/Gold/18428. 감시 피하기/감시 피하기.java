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

class Pos {
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	private static int N;
	private static boolean result;
	private static char[][] map;
	private static List<Pos> posList;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		
		map = new char[N][N];
		posList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				char c = st.nextToken().charAt(0);
				map[i][j] = c;
				
				if(c == 'T') {
					posList.add(new Pos(j, i));
				}
			}
		}
		
		dfs(0);
		
		if(result) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	static void dfs(int count) {
		if(count == 3) {
			// 여기서 학생들이 검거되는지 체크필요.
			int size = posList.size();
			
			for(Pos teacher : posList) {
				if(scanStudent(teacher)) {
					size--;
				}
			}
			
//			System.out.println(size);
			
			if(size == 0) {
				result = true;
			}
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(count + 1);
					map[i][j] = 'X';
				}
			}
		}
	}
	
	static boolean scanStudent(Pos teacher) {
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		boolean isPossible = true;
		
		for(int i = 0; i < 4; i++) {
			int nextX = teacher.x + dir[i][0];
			int nextY = teacher.y + dir[i][1];
			
			while(true) {
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) break;
				
				if(map[nextY][nextX] == 'O') break;
				
				if(map[nextY][nextX] == 'S') isPossible = false;
				
				nextX += dir[i][0];
				nextY += dir[i][1];
			}
		}
		
		return isPossible;
	}
}