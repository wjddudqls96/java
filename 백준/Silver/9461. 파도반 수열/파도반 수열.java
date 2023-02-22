import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Long[] DP;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		
		DP = new Long[200];
		DP[0] = (long) 1;
		DP[1] = (long) 1;
		DP[2] = (long) 1;
		DP[3] = (long) 2;
		DP[4] = (long) 2;
		
		for(int i = 0; i < t; i++) {
			N = Integer.parseInt(in.readLine());
			System.out.println(recursion(N - 1));
		}
		
		
	}
	
	static Long recursion(int cnt) {
		if(cnt < 5) {
			return DP[cnt];
		}
		
		if(DP[cnt] != null) {
			return DP[cnt];
		}
		
		DP[cnt] = recursion(cnt - 5) + recursion(cnt - 1);
		return DP[cnt];
	}
	
}