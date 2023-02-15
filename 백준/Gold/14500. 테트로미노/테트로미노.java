import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int M,N,H;
    static int[] input;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine());
        	for(int j = 0; j < M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		input = new int[3];
                combination(0, j, i);
        	}
        }
        System.out.println(max);
    }
    
    static void combination(int cnt, int x, int y) {
        if(cnt == 3) {
            int cx = x;
            int cy = y;
            int yTetlis = map[y][x];
            int sum = map[y][x];
            boolean flag = false;
            
            if(isy(input)) {
            	for(int i = 0; i < input.length; i++) {
            		int yx = x + directions[input[i]][0];
                    int yy = y + directions[input[i]][1];
            		if(yx < 0 || yx >= M || yy < 0 || yy >= N) break;
            			yTetlis += map[yy][yx]; 
            	}
             }
            
            for(int i = 0; i < input.length; i++) {
            	 cx = cx + directions[input[i]][0];
                 cy = cy + directions[input[i]][1];
                 if(cx < 0 || cx >= M || cy < 0 || cy >= N || isCycle(input)) {
                	 flag = true;
                	 break;
                 }
                 sum += map[cy][cx];
            }
            
            sum = Math.max(yTetlis, sum);
            
            if(!flag && max < sum) {
            	max = sum;
            }
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            input[cnt] = i;
            combination(cnt + 1, x, y);
        }
    }
    
    static boolean isCycle(int[] input) {
    	int prev = -10;
    	for(int i = 0; i < input.length; i++) {
        	if((prev == 0 && input[i] == 1) || (prev == 1 && input[i] == 0)) {
        		return true;
        	}
        	if((prev == 2 && input[i] == 3) || (prev == 3 && input[i] == 2)) {
        		return true;
        	}
        	prev = input[i];
        }
    	return false;
    }
    
    static boolean isy(int[] input) {
    	HashSet<Integer> set = new HashSet<>();
    	for(int i = 0; i < input.length; i++) {
    		set.add(input[i]);
    	}
    	
    	return set.size() == input.length;
    }
}