import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	private static int N, M;
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		
		int min = Integer.MAX_VALUE;
		
		// 1, 3, 5
		
		int i = 0, j = 1;
		
		while(i < N && j < N) {
			int dif = arr[j] - arr[i];
			
			if(dif < M) {
				j++;
				continue;
			}
			
			min = Math.min(min, dif);
			i++;
		}
		
		
		System.out.println(min);
		
	}
}