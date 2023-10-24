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
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		lamps = new int[M];
		
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < M; i++) {
			lamps[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이분 탐색을 이용하기
		int left = 1;
		int right = N;
		int result = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(isPossible(mid)) {
				right = mid - 1;
				result = mid;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean isPossible(int height) {
		int prev = 0;
		
		for(int i = 0; i < lamps.length; i++) {
			if(prev >= lamps[i] - height) {
				prev = lamps[i] + height;
			}
			else {
				return false;
			}
		}
		
		return N - prev <= 0;
	}
}