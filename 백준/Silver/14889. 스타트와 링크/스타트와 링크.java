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
    static int N;
    static boolean[] visit;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	map = new int[N][N];
    	visit = new boolean[N];
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    		for(int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	combi(0, 0);
    	System.out.println(min);
    }
	
	static void combi(int idx, int count) {
		// 팀 조합이 완성될 경우
		if(count == N / 2) {
			calculation();
			return;
		}
	 
		for(int i = idx; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				combi(i + 1, count + 1);
				visit[i] = false;
			}
		}
	}
	
	static void calculation() {
		int startTeam = 0;
		int linkTeam = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				
				if(visit[i] && visit[j]) {
					startTeam += map[i][j] + map[j][i];
				}
				else if(!visit[i] && !visit[j]) {
					linkTeam += map[i][j] + map[j][i];
				}
			}
		}
		
		min = Math.min(min, Math.abs(startTeam - linkTeam));
	}
}