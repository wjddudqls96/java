import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Shark> pq = new PriorityQueue<>();
    static ArrayList<Shark> temp = new ArrayList<>();
    static int N,M,cnt;
    static Shark[][] map;
    static int result;
    static int[][] direction = { {0,-1},{1,0},{0,1},{-1,0} }; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());
        
        map = new Shark[N][M];
        //상어 정보 입력 받음
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            switch (dir) {
            case 1:
                dir = 0;
                break;
            case 2:
                dir = 2;
                break;
            case 3:
                dir = 1;
                break;
            case 4:
                dir = 3;
                break;
            }
            int size = Integer.parseInt(st.nextToken());
            //상어 입장 뚠뚜뚜뚜
            map[y][x] = new Shark(x, y, s, dir, size);
        }

        for(int i = 0 ; i < M ; i++) {
            
            catchShark(i);
            
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    if(map[r][c] != null) {
                        pq.offer(map[r][c]);
                    }
                }
            }
            
            map = new Shark[N][M];
            
            while(!pq.isEmpty()) {
                sharkMove();
            } 
        }
        
        System.out.println(result);
    }
    
    private static void catchShark(int i) {
        for(int j = 0 ; j < N ; j++ ) {
            if( map[j][i] != null ) {
                result += map[j][i].size;
                map[j][i] = null;
                break;
            }
        }
    }

    //상어이동
    private static void sharkMove() {
        Shark s = pq.poll();
        
        
        int seconds = 0;
		// 위 혹은 아래 방향이면
		if (s.dir == 0 || s.dir == 2) {
			seconds = s.s % ((N - 1) * 2);
		}
		// 오른쪽 혹은 왼쪽 방향이면
		else if (s.dir == 1 || s.dir == 3) {
			seconds = s.s % ((M - 1) * 2);
		}

		
        for(int i = 0 ; i < seconds ; i++) {
        	
            s.x += direction[s.dir][0];
            s.y += direction[s.dir][1];
            
            meetingWall(s);
        }
        
        if(map[s.y][s.x] == null) {
            temp.add(s);
            map[s.y][s.x] = s;
        }
    }
    static boolean meetingWall(Shark s) {
        if( !cango(s.x,s.y) ) {
            s.dir = ( s.dir + 2 ) % 4;
            s.x += 2 * direction[s.dir][0];
            s.y += 2 * direction[s.dir][1];
            return true;
        }
        
        return false;
    }


    private static boolean cango(int x, int y) {
        if( x >= 0 && x < M && y >= 0 && y < N) {
            return true;
        }
        return false;
    }


    static class Shark implements Comparable<Shark>{
        int x,y,s,dir,size;

        public Shark(int x, int y, int s, int dir, int size) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.dir = dir;
            this.size = size;
        }

        @Override
        public int compareTo(Shark o) {
            // TODO Auto-generated method stub
            return o.size - this.size;
        }
        
    }
}