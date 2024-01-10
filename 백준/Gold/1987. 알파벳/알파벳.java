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
    static int R, C, max;
    static int[][] map, check;
    static boolean[] visit;
    static int[][] dir = {{1, 0},{0, 1},{-1, 0},{0, -1}};
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	
    	visit = new boolean[91];
    	map = new int[R][C];
    	check = new int[R][C];
    	
    	for(int i = 0; i < R; i++) {
    		String str = in.readLine();
    		
    		for(int j = 0; j < C; j++) {
    			map[i][j] = str.charAt(j) - '0';
    		}
    	}
    	
    	max = Integer.MIN_VALUE;
    	
    	dfs(0, 0, 1);
    	
    	System.out.println(max);
	}
	
	static void dfs(int x, int y, int count) {
		
		visit[map[y][x]] = true;
		check[y][x] = 1;
		
		
		if(max < count) {
			max = count;
		}
		
//		for(int[] a : check) {
//    		System.out.println(Arrays.toString(a));
//    	}
//		System.out.println();
		
		for(int i = 0; i <4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];
			
			if(nextX < 0 || nextX >= C || nextY < 0 || nextY >= R) continue;
			
			if(visit[map[nextY][nextX]]) continue;
			
			dfs(nextX, nextY, count + 1);
			visit[map[nextY][nextX]] = false;
			check[nextY][nextX] = 0;
		
		}
	}
	
}