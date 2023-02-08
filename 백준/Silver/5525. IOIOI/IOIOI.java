import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static String S;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		S = in.readLine();
		
		String p = "IOI";
		int count = 0;
		
		for(int i = 1; i < N; i++) {
			p += "OI";
		}
		
		for(int i = 0; i < S.length() - p.length(); i++) {
			if(S.substring(i, i + p.length()).equals(p)) {
				count++;
			}
		}
		System.out.println(count);
	}
}