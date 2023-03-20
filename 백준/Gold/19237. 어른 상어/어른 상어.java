import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark implements Comparable<Shark>{
	int x;
	int y;
	int no;
	int dir;
	// 위 아래 왼쪽 오른쪽 
	
	Shark(int x, int y, int no){
		this.x = x;
		this.y = y;
		this.no = no;
	}

	@Override
	public String toString() {
		return "Shark [x=" + x + ", y=" + y + ", no=" + no + ", dir=" + dir + "]";
	}

	@Override
	public int compareTo(Shark o) {
		// TODO Auto-generated method stub
		return this.no - o.no;
	}
}

class Smoke{
	int no;
	int count;
	
	Smoke(){
		this.no = 0;
		this.count = 0;
	}
	
	
	public Smoke(int no, int count) {
		super();
		this.no = no;
		this.count = count;
	}


	@Override
	public String toString() {
		return "Smoke [no=" + no + ", count=" + count + "]";
	}

}

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[][][] sharkDirs;
	static Smoke[][] smokeMap;
	static Queue<Shark> sharkq;
    public static void main(String[] args) throws Exception {
       
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(in.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        smokeMap = new Smoke[N][N];
        sharkq = new ArrayDeque<>();
        Shark[] sharks = new Shark[M];

        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(in.readLine());
        	for(int j = 0; j < N; j++) {
        		int sharkNum = Integer.parseInt(st.nextToken());
        		if(sharkNum != 0) {
        			sharks[sharkNum - 1] = new Shark(j, i, sharkNum);
        			sharkq.offer(sharks[sharkNum - 1]);
        			smokeMap[i][j] = new Smoke(sharkNum, K);
        		}
        		else {
        			smokeMap[i][j] = new Smoke();
        		}
        		map[i][j] = sharkNum;
        		
        	}
        }
        
        st = new StringTokenizer(in.readLine());
        
        // 상어에게 방향 주기
        for(int i = 0; i < M; i++) {
        	sharks[i].dir = Integer.parseInt(st.nextToken());
        }
        
        // 각 상어의 우선순위 방향을 담은 배열 
        sharkDirs = new int[M][4][4];
        // 위, 아래, 왼쪽, 오른쪽
        for(int i = 0; i < M * 4; i++) {
        	int sharkIdx = i / 4 ;
        	int dirIdx = i % 4;
        	st = new StringTokenizer(in.readLine());
        	for(int j = 0; j < 4; j++) {
        		int direction = Integer.parseInt(st.nextToken());
        		sharkDirs[sharkIdx][dirIdx][j] = direction;
        	}
        }
        
        PriorityQueue<Shark> pq = new PriorityQueue<>();
        
        while(!sharkq.isEmpty()) {
        	pq.add(sharkq.poll());
        }
        
        int cnt = 0;
        while(cnt <= 1000) {
        	cnt++;
        	// 한칸 움직이기 
        	while(!pq.isEmpty()) {
        		Shark shark = pq.poll();
        		moveShark(shark);
        	}
        	
        	while(!sharkq.isEmpty()) {
            	pq.add(sharkq.poll());
            }
        	
        	removeSmoke();
        	
        	createSmoke();
        	
//        	for(Smoke[] s : smokeMap) {
//        		System.out.println(Arrays.toString(s));
//        	}
//        	
//        	for(int[] m : map) {
//        		System.out.println(Arrays.toString(m));
//        	}
//        	System.out.println("==========================");
        	
        	
        	if(pq.size() == 1 && pq.peek().no == 1) {
        		break;
        	}
        }
        if(cnt > 1000) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(cnt);
        }
       
        
    }
    
    static void removeSmoke() {
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(smokeMap[i][j].count != 0 && smokeMap[i][j].no != 0) {
    				smokeMap[i][j].count--;
    				if(smokeMap[i][j].count == 0) {
    					smokeMap[i][j].no = 0;
    				}
    			}
    		}
    	}
    }
    
    static void createSmoke() {
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(map[i][j] != 0) {
    				smokeMap[i][j].count = K;
    				smokeMap[i][j].no = map[i][j];
    			}
    		}
    	}
    }
    
    static void moveShark(Shark shark) {
    	// 0 : 상 / 1 : 하 / 2 : 좌 / 3 : 우
    	int[] directions = sharkDirs[shark.no - 1][shark.dir - 1];
    	int[] mySmokeArea = new int[2];
    	int changdir = -1;
    	boolean flag = false;
    	boolean isMove = false;
    	
    	for(int i = 0; i < 4; i++) {
    		int[] pos = getNextMove(directions[i]);
    		int nextX = shark.x + pos[0];
    		int nextY = shark.y + pos[1];
    		
    		if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
    		
    		// 다음 갈 행성지에 다른 샤크의 냄새가 있다면 다음으로...
    		if(smokeMap[nextY][nextX].no != shark.no && smokeMap[nextY][nextX].no != 0) continue;
    		
    		if(smokeMap[nextY][nextX].no == shark.no) {
    			if(flag) continue;
    			
    			mySmokeArea[0] = nextX;
    			mySmokeArea[1] = nextY;
    			changdir = directions[i];
    			flag = true;
    			continue;
    		}
    		
    		map[shark.y][shark.x] = 0; 
    		
    		// 만약 상어가 있다면 죽어야된다.
    		if(map[nextY][nextX] == 0) {
    			shark.x = nextX;
        		shark.y = nextY;
        		shark.dir = directions[i];
        		map[shark.y][shark.x] = shark.no;
        		sharkq.add(shark);
    		}
    		isMove = true;
    		break;
    	}
    	
    	if(!isMove) {
    		int x = mySmokeArea[0];
    		int y = mySmokeArea[1];
    		map[shark.y][shark.x] = 0; 
    		
    		// 만약 상어가 있다면 죽어야된다.
    		if(map[y][x] == 0) {
    			shark.x = x;
        		shark.y = y;
        		shark.dir = changdir;
        		map[shark.y][shark.x] = shark.no;
        		sharkq.add(shark);
    		}
    	}
    }
    
    static int[] getNextMove(int type) {
    	int[] pos = new int[2];
    	
    	switch (type) {
    	// 상 
		case 1:
			pos[0] = 0;
			pos[1] = -1;
			break;
		// 하 
		case 2:
			pos[0] = 0;
			pos[1] = 1;
			break;
		// 좌 
		case 3:
			pos[0] = -1;
			pos[1] = 0;
			break;
		// 우 
		case 4:
			pos[0] = 1;
			pos[1] = 0;
			break;
		}
    	
    	return pos;
    }
  
}