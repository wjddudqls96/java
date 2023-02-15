import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		int[][] papers = new int[100][100];
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = y; i < y + 10; i++) {
				for(int j = x; j < x + 10; j++) {
					papers[i][j] = 1; 
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(papers[i][j] == 1) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}