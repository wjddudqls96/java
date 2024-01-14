import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 횟수
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 우주선 개수
			double P = Double.parseDouble(st.nextToken()); // 목적지까지의 거리

			int count = 0;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				double v = Double.parseDouble(st.nextToken()); // 우주선 최고속도
				double f = Double.parseDouble(st.nextToken()); // 우주선의 연료량
				double c = Double.parseDouble(st.nextToken()); // 우주선의 연료소비율

				if ((P / v) * c <= f) // (거리/속도)*연료소비율 <= 연료량
					count++;
			}
			System.out.println(count);
		}
	}
}