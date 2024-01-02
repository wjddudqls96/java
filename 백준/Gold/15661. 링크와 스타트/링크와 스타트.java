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
	static int N, result;
	static boolean[] visit;
	static int[][] map;

	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	N = Integer.parseInt(in.readLine());
    	visit = new boolean[N];
    	map = new int[N][N];
    	result = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    		
    		for(int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	subSet(0, 0);
    	
    	System.out.println(result);
    }
	
	static void subSet(int count, int subSetCnt) {
		
		if(count == N) {
			if(subSetCnt >= 1 && subSetCnt < N) {
				calculation();
			}
			return;
		}
		
		visit[count] = true;
		subSet(count + 1, subSetCnt + 1);
		visit[count] = false;
		subSet(count + 1, subSetCnt);
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
		
		result = Math.min(result, Math.abs(startTeam - linkTeam));
	}
}