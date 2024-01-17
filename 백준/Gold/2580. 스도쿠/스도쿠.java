import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;



public class Main {
	static int[][] map;
	static boolean flag;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	map = new int[9][9];
    	
    	for(int i = 0; i < 9; i++) {
    		st = new StringTokenizer(in.readLine());
    		for(int j = 0; j < 9; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	dfs(0, 0);
    	System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		
		if(x >= 9) {
			dfs(0, y + 1);
			return;
		}
		
		if(y > 8) {
			for(int[] m : map) {
				for(int n : m) {
					sb.append(n + " ");
				}
				sb.append("\n");
			}
			flag = true;
			return;
		}
		
		if(map[y][x] == 0) {
			for(int i = 1; i <= 9; i++) {
				
				// 만약 놓을수 있다면 놓는다.
				map[y][x] = i;
				
				if(isPossible(x, y)) {
					dfs(x + 1, y);
				}
				
				if(flag) {
					return;
				}
			}
			
			map[y][x] = 0;
		}
		else {
			dfs(x + 1, y);
		}
	}
	
	static boolean isPossible(int x, int y) {
		// 1. 가로가가능한지
		for(int i = 0; i < 9; i++) {
			if (i != y && map[i][x] == map[y][x]) return false; //세로
            if (i != x && map[y][i] == map[y][x]) return false; //가로
		}
		
		// 3. 블럭이 가능한지.
		int startX = 3 * (x / 3);
		int startY = 3 * (y / 3);
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(startX + j == x && startY + i == y) continue;
				
				if(map[startY + i][startX + j] == map[y][x]) return false;
			}
		}
		
		return true;
	}
}