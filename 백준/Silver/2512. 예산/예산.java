import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			int price = Integer.parseInt(st.nextToken());
			arr[i] = price;
		}
		
		// 1. 이분 탐색전 정렬
		Arrays.sort(arr);
		
		// 2. 이분탐색 시작
		int start = 0;
		int end = arr[arr.length - 1];
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				if(mid < arr[i]) {
					sum += mid;
				}
				else {
					sum += arr[i];
				}
			}
			
			// 만약 합이 M보다 크다면 mid를 end에 대치 아니면 start
			if(sum > M) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		
		System.out.println(end);
	}
}