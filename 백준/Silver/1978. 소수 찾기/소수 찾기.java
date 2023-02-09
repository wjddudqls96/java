import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M;
	static boolean[][] visited;
	static int[][] result;
	static boolean[] prime;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		String[] split = in.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		
		Arrays.sort(arr);
		
		make_prime(arr[arr.length - 1]);
		
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(!prime[arr[i]]) cnt++;
		}
		
		System.out.println(cnt);
		
		
	}
	
	public static void make_prime(int N) {
		
		prime = new boolean[N + 1];
 
		if(N < 2) {
			return;
		}
        
		prime[0] = prime[1] = true;
		
        
		for(int i = 2; i <= Math.sqrt(N); i++) {
        
			if(prime[i] == true) {
				continue;
			}
        
			for(int j = i * i; j < prime.length; j = j+i) {
				prime[j] = true;
			}
		}
 
	}
}