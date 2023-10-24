import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	static int[] lamps;
	static int N;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st, st2;

		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		int[] distances = new int[N - 1];
		int[] prices = new int[N];
		
		for(int i = 0; i < N - 1; i++) {
			distances[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		
		long temp = prices[0];
		long sum = 0;
		
		for(int i = 0; i < N - 1; i++) {
			int nextPrices = prices[i + 1];
			sum += (distances[i] * temp);
			
			if(temp >= nextPrices) {
				temp = nextPrices;
			}
		}
		
		System.out.println(sum);
	}
}