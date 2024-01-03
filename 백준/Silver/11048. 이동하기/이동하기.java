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
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	int[][] dp = new int[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    		for(int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	dp[0][0] = map[0][0];
    	
    	int[][] dir = {{0, 1}, {1, 0}, {1, 1}};
    	
    	//DP를 이용한 풀이 시작. 
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			int cnt = map[i][j];
    			
    			for(int d = 0; d < 3; d++) {
    				int nextX = j + dir[d][0];
    				int nextY = i + dir[d][1];
    				
    				if(isPossible(nextX, nextY)) {
    					dp[nextY][nextX] = Math.max(dp[nextY][nextX], dp[i][j] + map[nextY][nextX]);
    				}
    			}
    		}
    	}
    	
    	
    	System.out.println(dp[N - 1][M - 1]);
    }
	
	static boolean isPossible(int x, int y) {
		if(x >= M || x < 0 || y < 0 || y >= N) 
			return false;
		
		return true;
	}
}