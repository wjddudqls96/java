import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	int num;
	
	Pos(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + ", num=" + num + "]";
	}
}

public class Main {
	static int R,C,T;
	static ArrayList<Pos> airCondis;
	static Queue<Pos> queue = new ArrayDeque<Pos>();
	static int[][] map;
	static boolean[][] visited;
	
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(in.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        visited = new boolean[R][C];
        
        airCondis = new ArrayList<>();
        
        for(int i = 0; i < R; i++) {
        	st = new StringTokenizer(in.readLine());
        	for(int j = 0; j < C; j++) {
        		int num = Integer.parseInt(st.nextToken());
        		
        		if(num == -1) {
        			airCondis.add(new Pos(j, i, num));
        		}
        		else if(num != 0){
        			queue.offer(new Pos(j, i, num));
        		}
        		map[i][j] = num;
        	}
        }
        
        for(int t = 0; t < T; t++) {
        	// 미세먼지 확산 
        	bfs();
        	
        	// 공기청정기 작동
            generationTop();
            generationBottom();
            
         // 미세먼지 찾아서 큐에 넣기;
        	inputQ();
        }
  
        System.out.println(getResult());
    }
    
    static void inputQ() {
    	for(int i = 0; i < R; i++) {
        	for(int j = 0; j < C; j++) {
        		int num = map[i][j];
        		if(num != 0 && num != -1){
        			queue.offer(new Pos(j, i, num));
        		}
        	}
        }
    }
    
    static int getResult() {
    	int result = 0;
    	
    	for(int i = 0; i < R; i++) {
        	for(int j = 0; j < C; j++) {
        		int num = map[i][j];
        		if(num != 0 && num != -1){
        			result += num;
        		}
        	}
        }
    	
    	return result;
    }
    
    static void bfs() {
    	int[][] directions = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    	while(!queue.isEmpty()) {
    		Pos current = queue.poll();

    		int count = 0;
    		
    		for(int i = 0; i < 4; i++) {
    			int nextX = current.x + directions[i][0];
    			int nextY = current.y + directions[i][1];
    			
    			if(nextX < 0 || nextX >= C || nextY < 0 || nextY >= R) continue;
    			
    			if(map[nextY][nextX] == -1) continue;
    			
    			count++;
    			map[nextY][nextX] += current.num / 5;
    		}
    		
    		map[current.y][current.x] -= count * (current.num / 5);
    	}
    }
    
    static void generationTop() {
    	Pos airTop = airCondis.get(0);
    	
    	// 위의 공기청정기일 경우
    	int tx = airTop.x;
    	int ty = airTop.y;
    	int temp = 0;
    	int temp2 = 0;
    	
    	// 오른쪽 가기
    	for(int i = 0; i < C - 1; i++) {
    		tx += 1;
    		temp2 = map[ty][tx];
    		map[ty][tx] = temp;
    		temp = temp2;
    	}
    	
    	// 위쪽 가기
    	for(int i = 0; i < airTop.y; i++) {
    		ty -= 1;
    		temp2 = map[ty][tx];
    		map[ty][tx] = temp;
    		temp = temp2;
    	}
    	
    	// 왼쪽 가기
    	for(int i = 0; i < C - 1; i++) {
    		tx -= 1;
    		temp2 = map[ty][tx];
    		map[ty][tx] = temp;
    		temp = temp2;
    	}
    	
    	// 아래쪽 가기
    	for(int i = 0; i < airTop.y - 1; i++) {
    		ty += 1;
    		temp2 = map[ty][tx];
    		map[ty][tx] = temp;
    		temp = temp2;
    	}
    }
    
    static void generationBottom() {
    	 Pos airBottom = airCondis.get(1);
    	 
    	   	// 위의 공기청정기일 경우
     	int tx = airBottom.x;
     	int ty = airBottom.y;
     	int temp = 0;
     	int temp2 = 0;
     	
     	// 오른쪽 가기
     	for(int i = 0; i < C - 1; i++) {
     		tx += 1;
     		temp2 = map[ty][tx];
     		map[ty][tx] = temp;
     		temp = temp2;
     	}
     	
     // 아래쪽 가기
     	for(int i = 0; i < R - airBottom.y - 1; i++) {
     		ty += 1;
     		temp2 = map[ty][tx];
     		map[ty][tx] = temp;
     		temp = temp2;
     	}
     	
     	// 왼쪽 가기
     	for(int i = 0; i < C - 1; i++) {
     		tx -= 1;
     		temp2 = map[ty][tx];
     		map[ty][tx] = temp;
     		temp = temp2;
     	}
     	
     // 위쪽 가기
     	for(int i = 0; i < R - airBottom.y - 2; i++) {
     		ty -= 1;
     		temp2 = map[ty][tx];
     		map[ty][tx] = temp;
     		temp = temp2;
     	}
     	
    }
   
}