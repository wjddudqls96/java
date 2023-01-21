import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Main {
	static Character[][] map;
	static int R;
	static int C;
	static int max;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[] visit = new boolean[26];
	
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        String[] split = in.readLine().split(" ");
        
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        
        map = new Character[R][C];
        
        for(int i = 0; i < R; i++) {
        	String line = in.readLine();
        	for(int j = 0; j < C; j++) {
        		map[i][j] = line.charAt(j);
        	}
        }
        
        max = 0;
        
        dfs(0, 0, 0);
        
        System.out.println(max); 
    }
    
    static void dfs(int x, int y, int count){
    	if(visit[map[y][x] - 'A']){
    		if(max < count) {
    			max = count;
    		}
    	}
    	else {
    		visit[map[y][x] - 'A'] = true;
    		
        	for(int i = 0 ; i < 4; i++) {
        		int nextX = x + dx[i];
        		int nextY = y + dy[i];
        		
        		if(nextX >= 0 && nextX < C && nextY >= 0 && nextY < R) {
            		dfs(nextX, nextY, count + 1);
            	}
        		
        	}
        	
        	visit[map[y][x] - 'A'] = false;
    	};
    }
    
    
}