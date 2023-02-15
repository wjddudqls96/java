import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String[] split = in.readLine().split(" ");
		
		for(int i = 0; i < split.length; i++) {
			command(Integer.parseInt(split[i]));
		}
		
		
		for(int[] n : map) {
			for(int num : n) {
				sb.append(num + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void command(int num) {
		switch (num) {
		case 1:
			oneCommand();
			break;
		case 2:
			twoCommand();
			break;
		case 3:
			treeCommand();
			break;
		case 4:
			fourCommand();
			break;
		case 5:
			fiveCommand();
			break;
		case 6:
			sixCommand();
			break;
		}
	}
	
	static void oneCommand() {
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M; j++) {
				int temp = map[i][j];
				map[i][j] = map[N - i - 1][j];
				map[N - i - 1][j] = temp;
			}
		}
	}
	
	static void twoCommand() {
		for(int i = 0; i < M/2; i++) {
			for(int j = 0; j < N; j++) {
				int temp = map[j][i];
				map[j][i] = map[j][M - i - 1];
				map[j][M - i - 1] = temp;
			}
		}
	}
	
	static void treeCommand() {
		int[][] newArr = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			for(int j = N - 1; j >= 0; j--) {
				newArr[i][N - 1 - j] = map[j][i];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		map = newArr;
	}
	
	static void fourCommand() {
		int[][] newArr = new int[M][N];
		
		for(int i = M - 1; i >= 0; i--) {
			for(int j = 0; j < N; j++) {
				newArr[M - 1 - i][j] = map[j][i];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		map = newArr;
	}
	
	static void fiveCommand() {
		int[][] temp = new int[N][M];
		
		for(int i = 0; i < N/2; i++) {
			for(int j = M/2; j < M; j++) {
				temp[i][j] = map[i][j - M/2];
			}
		}
		
		for(int i = N/2; i < N; i++) {
			for(int j = M/2; j < M; j++) {
				temp[i][j] = map[i - N/2][j];
			}
		}
		
		for(int i = N/2; i < N; i++) {
			for(int j = M/2; j < M; j++) {
				temp[i][j - M/2] = map[i][j];
			}
		}
		
		for(int i = N/2; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[i - N/2][j] = map[i][j];
			}
		}
		map = temp;
	}
	
	static void sixCommand() {
		int[][] temp = new int[N][M];
		
		for(int i = 0; i < N/2; i++) {
			for(int j = M/2; j < M; j++) {
				temp[i][j - M/2] = map[i][j];
			}
		}
		
		for(int i = N/2; i < N; i++) {
			for(int j = M/2; j < M; j++) {
				temp[i - N/2][j] = map[i][j];
			}
		}
		
		for(int i = N/2; i < N; i++) {
			for(int j = M/2; j < M; j++) {
				temp[i][j] = map[i][j - M/2];
			}
		}
		
		for(int i = N/2; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[i][j] = map[i - N/2][j];
			}
		}
		map = temp;
	}
}