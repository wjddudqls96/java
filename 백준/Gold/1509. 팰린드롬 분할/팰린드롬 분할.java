import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = br.readLine();
		char[] arr = str.toCharArray();

		int n = str.length();
		int dp[][] = calcPalindrome(arr, n);
		int ans = calcDividedPalindrome(dp, n);
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	public static int[][] calcPalindrome(char arr[], int n) {
		int dp[][] = new int[n + 1][n + 1];

		// 길이가 1일 때
		for (int i = 1; i <= n; i++) {
			dp[i][i] = 1;
		}

		// 길이가 2일 때
		for (int i = 1; i <= n - 1; i++) {
			if (arr[i - 1] == arr[i]) {
				dp[i][i + 1] = 1;
			}
		}

		// 길이가 3 이상
		for (int i = 3; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++) {
				int k = j + i - 1;
				if (arr[j - 1] == arr[k - 1] && dp[j + 1][k - 1] == 1) {
					dp[j][k] = 1;
				}
			}
		}

		return dp;
	}

	public static int calcDividedPalindrome(int dp[][], int n) {
		int maxDivided[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			maxDivided[i] = -1;
			for (int j = 1; j <= i; j++) {
				if (dp[j][i] == 1) {
					if (maxDivided[i] == -1 || maxDivided[i] > maxDivided[j - 1] + 1) {
						maxDivided[i] = maxDivided[j - 1] + 1;
					}
				}
			}
		}

		return maxDivided[n];
	}
}