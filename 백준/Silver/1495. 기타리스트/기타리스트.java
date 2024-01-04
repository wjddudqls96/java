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
	static int N, S, M;
	static int[] volume;
	public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(in.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(in.readLine());
    	
    	volume = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++) {
    		volume[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	// DP 시작.
    	int[][] DP = new int[N + 1][M + 1];
    	DP[0][S] = 1;
    	
    	for (int i = 1; i < N + 1; i++) {
    		
            for(int j = 0; j < M + 1;j++){
            	
                if(DP[i-1][j]==1){
                	
                    if(j + volume[i] <= M){
                    	DP[i][j + volume[i]] = 1;
                    }
                    
                    if(j - volume[i] >= 0){
                    	DP[i][j - volume[i]] = 1;
                    }
                }

            }

        }
    	
    	int max = -1;
    	
        for(int i = 0; i < M + 1; i++){
            if(DP[N][i] == 1){
            	max = Math.max(max, i);

            }
        }

        System.out.println(max);
    	
    }
}