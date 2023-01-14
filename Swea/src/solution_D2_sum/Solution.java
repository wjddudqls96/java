package solution_D2_sum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/solution_D2_sum/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int testCase = 1; testCase <= 10 ; testCase++) {
			int T = Integer.parseInt(in.readLine());
			
			sb.append("#" + T + " ");
			
			int[][] arr = new int[100][100];
			int[] results = new int[202];
			// 배열 만드는 부분
			for(int i = 0; i < 100; i++) {
				String[] split = in.readLine().split(" ");
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(split[j]);
				}
			}
			// 행 합
			int sum = 0;
			int count = 0;
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				results[count++] = sum;
				sum = 0;
			}
			
			// 열 합
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				results[count++] = sum;
				sum = 0;
			}
			//대각선 합들
			int diagonalSum1 = 0;
			int diagonalSum2 = 0;
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					if(i == j) {
						diagonalSum1 += arr[i][j];
					}
					if(i + j == 99) {
						diagonalSum2 += arr[i][j];
					}
				}
			}
			
			results[count++] = diagonalSum1;
			results[count] = diagonalSum2;
			
			int max = Integer.MIN_VALUE;
			
			for(int i = 0; i < 202; i++) {
				if(max < results[i]) {
					max = results[i];
				}
			}
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
