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
		
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		
		int[] arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int temp = 0;
		int start = 1;
		int result = 0;
		int count = 0;
		
		for(int i = 1; i <= N; i++) {
			if(i <= X) {
				temp += arr[i];
			}
			else {
				temp += (arr[i] - arr[start]);
				start++;
			}
			
			
			if(result < temp) {
				result = temp;
				count = 1;
			}
			else if(result == temp){
				count++;
			}
		}
		
		
		if(result == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(result);
			System.out.println(count);
		}
	}
}