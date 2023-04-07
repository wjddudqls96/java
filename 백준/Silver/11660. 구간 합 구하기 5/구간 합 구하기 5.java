import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;  // 표의 크기
	private static int M;  // 합을 구해야 하는 횟수

	// L[i]: 어떤 수 i를 이진수로 나타냈을 때, 마지막 1이 나타내는 값
	// L[3] = 1, L[10] = 2, L[12] = 4
	// tree[i]는 nums[i] 부터 앞으로(좌측으로) L[i]개의 합이 저장되어 있음
	private static long[][] tree;

	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tree = new long[N + 1][N + 1];

		// N * N개의 수 저장
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				update(i, j, Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			long answer = intervalSum(x1, y1, x2, y2);
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	// i번째 수를 diff만큼 더하는 함수
	private static void update(int i, int j, long diff) {
		while (i <= N) {
			int temp = j;

			while (temp <= N) {
				tree[i][temp] += diff;
				temp += (temp & -temp);
			}

			// i & -i는 L[i]
			// L[i]: 어떤 수 i를 이진수로 나타냈을 때, 마지막 1이 나타내는 값
			// L[3] = 1, L[10] = 2, L[12] = 4
			// 0이 아닌 마지막 비트만큼 더하면서 이동
			i += (i & -i);
		}
	}

	// 1부터 N까지의 합(누적 합) 구하기
	private static long prefixSum(int i, int j) {
		long result = 0;
		while (i > 0) {
			int temp = j;

			while (temp > 0) {
				result += tree[i][temp];
				temp -= (temp & -temp);
			}

			// 0이 아닌 마지막 비트만큼 빼가면서 이동
			i -= (i & -i);
		}

		return result;
	}

	private static long intervalSum(int x1, int y1, int x2, int y2) {
		// (x2, y2)까지의 합 - 좌측 하단 - 우측 상단 + 중복 제거된 영역
		return prefixSum(x2, y2) - prefixSum(x2, y1 - 1) - prefixSum(x1 - 1, y2) + prefixSum(x1 - 1, y1 - 1);
	}

}