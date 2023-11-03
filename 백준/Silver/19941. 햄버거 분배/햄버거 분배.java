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
		int K = Integer.parseInt(st.nextToken());
		String line = in.readLine();
		char[] arr = line.toCharArray();
		int count = 0;
		
		for(int i = 0; i < line.length(); i++) {
			char c = arr[i];
			
			if(c != 'P') continue;
			
			// 왼쪽
			boolean flag = false;
			for(int j = Math.max(0, i - K); j < i; j++) {
				if(arr[j] == 'H') {
					count++;
					flag = true;
					arr[j] = 'X';
					break;
				}
			}
			
			// 오른쪽
			if(!flag) {
				for(int j = i + 1; j <= Math.min(line.length() - 1, i + K); j++) {
					if(arr[j] == 'H') {
						count++;
						arr[j] = 'X';
						break;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}