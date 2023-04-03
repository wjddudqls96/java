import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N;
	static ArrayList<Pos> list;
	static boolean dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine()) + 2;
			
			dp = new boolean[N][N];
			list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.add(new Pos(x, y));
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int startX = list.get(i).x;
					int startY = list.get(i).y;
					
					int x = list.get(j).x;
					int y = list.get(j).y;
					
					int dist = Math.abs(startX - x) + Math.abs(startY - y);
					
					if(dist <= 1000) {
						dp[i][j] = true;
					}
				}
			}
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) { 
						if(dp[i][k] && dp[k][j]) {
							dp[i][j] = true;
						}
					}
				}
			}
			
			if(dp[0][N - 1]) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
		}
	}
}