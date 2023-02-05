import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		
		String[] split1 = in.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split1[i]);
		}
		
		int M = Integer.parseInt(in.readLine());
		int[] arr2 = new int[M];
		
		String[] split2 = in.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(split2[i]);
		}
		
		Arrays.sort(arr);
		
		for(int num : arr2) {
			int result = binarySearch(num, 0, arr.length - 1, arr);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	
	static int binarySearch(int key, int start, int end, int[] arr) {
		while(start <= end) {
			int mid = (end + start) / 2;
			
			if(key > arr[mid]) {
				start = mid + 1;
			}
			else if(key < arr[mid]) {
				end = mid - 1;
			}
			else if(key == arr[mid]){
				return 1;
			}
		}
		return 0;
	}
}