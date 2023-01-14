package solution_d2_1204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution{
	
	public static void main(String[] args) throws Exception {
		
		/*
		 *  0. �Է����� �о���̱�
		 * */
		
		//System.setIn(new FileInputStream("1204_input.txt"));
		// bufferedReader �ӵ� ������ �������ִ� ������Ʈ��, inputSteamReader �� ��Ʈ��
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// ����� �� ���� ����ϱ� ���� StringBuilder ���� -> �Ѱ��� ����ϸ� �ӵ����� ������ ��ħ.
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			int caseNum = Integer.parseInt(in.readLine());
			int N = 1000;
			int[] scores = new int[N];
			
			String readLine = in.readLine();
			String[] split = readLine.split(" ");
			
			for(int i = 0; i < N; i++) {
				scores[Integer.parseInt(split[i])]++;
			}
			
			int max = Integer.MIN_VALUE;
			int maxIndex = 0;
			
			for(int i = 0; i < N; i++) {
				if(scores[i] >= max) {
					max = scores[i];
					maxIndex = i;
				}
			}
			
			sb.append(maxIndex).append("\n");

		}
		
		System.out.println(sb);
	}
}
