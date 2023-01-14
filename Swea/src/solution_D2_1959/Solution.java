package solution_D2_1959;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		
		for(int testCase = 1; testCase <= T; testCase++) {
			String NM = in.readLine();
			sb.append("#"+testCase+" ");
			String[] lineA = in.readLine().split(" ");
			String[] lineB = in.readLine().split(" ");
			
			int[] A = new int[lineA.length];
			int[] B = new int[lineB.length];
			
			for(int i = 0; i < A.length; i++) {
				A[i] = Integer.parseInt(lineA[i]);
			}
			
			for(int i = 0; i < B.length; i++) {
				B[i] = Integer.parseInt(lineB[i]);
			}
			
			
			int[] longer = A;
			int[] shorter = B;
			
			if(A.length < B.length) {
				longer = B;
				shorter = A;
			}
			
			int gap = longer.length - shorter.length;
			int max = Integer.MIN_VALUE;
			int sum = 0;
			
			for(int i = 0; i <= gap; i++) {
				for(int j = i; j < shorter.length + i; j++) {
					sum += shorter[j-i] * longer[j];
				}
				if(sum > max) {
					max = sum;
				}
				sum = 0;
			}
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
