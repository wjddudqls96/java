import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T, X, Y;
 
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			N =Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken()) -1;
			Y = Integer.parseInt(st.nextToken()) -1;
			
			int count = 0;
			int xNum = 1;
			int yNum = 1;
			boolean check =false;
			
			for (int i = X; i < (N * M); i += M) {
				if (i % N == Y) {
					System.out.println(i + 1);
					check = true;
					break;
				}
			}

			if (!check) {
				System.out.println(-1);

			}
		}
	}
}