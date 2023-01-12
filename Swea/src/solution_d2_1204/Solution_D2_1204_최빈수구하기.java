package solution_d2_1204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D2_1204_최빈수구하기 {
	
	public static void main(String[] args) throws Exception {
		
		/*
		 *  0. 입력파일 읽어들이기
		 * */
		
		//System.setIn(new FileInputStream("1204_input.txt"));
		// bufferedReader 속도 느린걸 보완해주는 보조스트림, inputSteamReader 주 스트림
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 결과를 한 번에 출력하기 위한 StringBuilder 생성 -> 한개씩 출력하면 속도에서 영향을 미침.
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
