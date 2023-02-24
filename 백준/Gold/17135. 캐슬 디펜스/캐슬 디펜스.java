import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N,M,D, enemyCnt, killCnt, eCnt, MAX;
	static int[][] map, copyMap;
	static int[] input;
	static boolean[][] visited;
	static ArrayList<Pos> possibleLands;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		possibleLands = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					enemyCnt++;
				}
				map[i][j] = num;
			}
		}
		
		input = new int[3];
		MAX = Integer.MIN_VALUE;
		
		combi(0, 0);
		
		System.out.println(MAX);
	}
	
	static void combi(int cnt, int start) {
		if(cnt == 3) {
			Pos[] attackers = new Pos[3];
			killCnt = 0;
			eCnt = enemyCnt;
			copyMap = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				copyMap[i] = Arrays.copyOf(map[i], map[i].length);
			}
			
			while(eCnt > 0) {
				ArrayList<Pos> kills = new ArrayList<>();
				for(int i = 0; i < 3; i++) {
					Pos attacker = new Pos(input[i], N - 1);
					kills.add(attack(attacker));
				}
				
				for(Pos kill : kills) {
					if(kill.x == -1) continue;
					
					if(copyMap[kill.y][kill.x] == 1) {
						copyMap[kill.y][kill.x] = 0;
						eCnt--;
						killCnt++;
					}
				}
				
				move();
			}
			
			if(MAX < killCnt) {
				MAX = killCnt;
			}
			
			return;
		}
		
		for(int i = start; i < M; i++) {
			input[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}
	
	static Pos attack(Pos pos) {
		Pos kill = new Pos(-1, -1);
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if(copyMap[i][j] == 1) {
					int distance = Math.abs(pos.x - j) + Math.abs(pos.y - i);
					
					if(distance < D ) {
						if(min > distance) {
							min = distance;
							kill = new Pos(j, i);
						}
						else if(distance == min) {
							if(kill.x > j) {
								kill = new Pos(j, i);
							}
						}
					}
				}
			}
		}
		
		return kill;
	}
	
	
	static void move() {
		for(int i = N - 1; i >= 1; i--) {
			for(int j = 0; j < M; j++) {
				if(i == N - 1 && copyMap[N - 1][j] == 1) {
					eCnt--;
				}
				copyMap[i][j] = copyMap[i - 1][j];
			}
		}
		
		for(int i = 0; i < M; i++) {
			copyMap[0][i] = 0;
		}
	}
}