import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int recurCnt = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = Math.min(N, M) / 2;
		for(int r = 0; r < recurCnt; r++) {
			for(int i = 0; i < cnt; i++) {
				int startX = i;
				int startY = i;
				int endX = M - i - 1;
				int endY = N - i - 1;
				
				int x = startX;
				int y = startY;
				
				int temp = map[startY][startX];
				while(true) {
					if(x < endX && y == startY) {
						map[y][x] = map[y][x + 1];
						x++;
					}
					else if(x == endX && y < endY) {
						map[y][x] = map[y + 1][x];
						y++;
					}
					else if(y == endY && x > startX) {
						map[y][x] = map[y][x - 1];
						x--;
					}
					else if(x == startX && y >= startY) {
						map[y][x] = map[y - 1][x];
						y--;
						
						if(y == startY) {
							map[startY + 1][startX] = temp;
							break;
						}
					}
				}
			}
		}
		
		for(int[] nums : map) {
			for(int num : nums) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
	}
}