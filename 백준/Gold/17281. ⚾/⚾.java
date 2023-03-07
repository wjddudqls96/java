import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, result, outCnt, max;
    static boolean[] visited;
    static int[] input, roo;
    static int[][] score;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(in.readLine());
        
        score = new int[N][9];
        
        for(int t = 0; t < N; t++) {
        	st = new StringTokenizer(in.readLine());
        	
        	for(int i = 0; i < 9; i++) {
        		score[t][i] = Integer.parseInt(st.nextToken());
        	}
        }
        
        input = new int[8];
        visited = new boolean[9];
        roo = new int[4];
        max = Integer.MIN_VALUE;
        permutation(0);
        System.out.println(max);
    }
    
    static void permutation(int cnt) {
        if(cnt == 8) {
            int[] players = new int[9];
            players[3] = 0;
            
            for(int i = 0; i < 9; i++) {
                if(i == 3) continue;
                
                if(i > 3) {
                    players[i] = input[i - 1];
                }
                else {
                    players[i] = input[i];
                }
            }
            
            int start = 0;
            int result = 0;
            
            for(int i = 0; i < N; i++) {
            	outCnt = 0;
            	while(outCnt != 3) {
            		play(score[i][players[start]]);
            		start = (start + 1) % 9;
            	}
            	
            	result += roo[3];
            	Arrays.fill(roo, 0);
            }
            
            if(max < result) {
            	max = result;
            }
            return;
        }
        
        for(int i = 1; i < 9; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            input[cnt] = i;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
    
    static void play(int type) {
        switch (type) {
        case 0:
        	outCnt++;
            break;
        case 1:
            if(roo[2] != 0) {
            	roo[2]--;
            	roo[3]++;
            }
            if(roo[1] != 0) {
            	roo[1]--;
            	roo[2]++;
            }
            if(roo[0] != 0) {
            	roo[0]--;
            	roo[1]++;
            }
            roo[0]++;
            break;
        case 2:
        	if(roo[2] != 0) {
            	roo[2]--;
            	roo[3]++;
            }
            if(roo[1] != 0) {
            	roo[1]--;
            	roo[3]++;
            }
            if(roo[0] != 0) {
            	roo[0]--;
            	roo[2]++;
            }
            roo[1]++;
            break;
        case 3:
        	if(roo[2] != 0) {
            	roo[2]--;
            	roo[3]++;
            }
            if(roo[1] != 0) {
            	roo[1]--;
            	roo[3]++;
            }
            if(roo[0] != 0) {
            	roo[0]--;
            	roo[3]++;
            }
            roo[2]++;
            break;
        case 4:
        	if(roo[2] != 0) {
            	roo[2]--;
            	roo[3]++;
            }
            if(roo[1] != 0) {
            	roo[1]--;
            	roo[3]++;
            }
            if(roo[0] != 0) {
            	roo[0]--;
            	roo[3]++;
            }
            roo[3]++;
            break;
        }
    }
}