import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N];
			int max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(max < num) {
					max = num;
				}
				arr[i] = num;
			}
			
			
			for(int i = 0; i < N; i++) {
				arr[i] = max - arr[i];
			}
			
			Arrays.sort(arr);
//			System.out.println(Arrays.toString(arr));
//			System.out.println("============");
			int count = 0;
			
			while(true) {
				int start = -1;
				int target = -1;
				for(int i = 0; i < arr.length; i++) {
					if(arr[i] > 0) {
						start = i;
						break;
					}
				}
				
				if(start == -1) break;
				
				for(int i = start; i < arr.length; i++) {
					if(arr[i] == 2 && i == start) continue;
					if(arr[i] > 1) {
						target = i;
						break;
					}
				}
				
				if(target == -1) break;
				
				arr[start] -= 1;
				arr[target] -= 2;
				
				count += 2;
//				System.out.println(Arrays.toString(arr));
			}
			
//			System.out.println(Arrays.toString(arr));
			int index = 0;
			int cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == 1) {
					index = 1;
					cnt += 1;
				}
				else if(arr[i] == 2){
					index = 2;
					cnt += 1;
				}
			}
			if(index == 1) {
				count += (cnt * 2) - 1;
			}
			else if(index == 2) {
				count += (cnt * 2);
			}
			
			sb.append("#" + t + " " + count).append("\n");
		}
		System.out.println(sb);
	}
}