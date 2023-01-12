package solution_D3_1213;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1213_String {
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1213_input.txt"));
		// bufferedReader 속도 느린걸 보완해주는 보조스트림, inputSteamReader 주 스트림
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 결과를 한 번에 출력하기 위한 StringBuilder 생성 -> 한개씩 출력하면 속도에서 영향을 미침.
		StringBuilder sb = new StringBuilder();
		
		String T;
		
		while ((T = in.readLine()) != null) {
			sb.append("#" + T + " ");
			String search = in.readLine();
			String line = in.readLine();
			line = " " + line + " ";
			String[] split = line.split(search);
			sb.append(split.length - 1).append("\n");
        }
		
		System.out.println(sb);
	}
}
