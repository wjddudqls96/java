import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		arr = new long[N];
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);

		int leftIndex = 0;
		int rightIndex = arr.length - 1;
		
		Long min = Long.MAX_VALUE;
		Long result1 = (long) -1;
		Long result2 = (long) -1;
		
		Long sum;
		Long temp;
		
		while(leftIndex < rightIndex) {
			sum = arr[leftIndex] + arr[rightIndex];
			temp = Math.abs(sum);
			
			if(temp < min) {
				min = temp;
				result1 = arr[leftIndex];
				result2 = arr[rightIndex];
			}
			
			if(sum > 0) {
				rightIndex--;
			}
			else {
				leftIndex++;
			}
		}
		
		System.out.println(result1 + " " + result2);
	}
}