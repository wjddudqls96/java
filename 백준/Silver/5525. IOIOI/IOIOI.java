import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static String S;
	static int[] numbers;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		S = in.readLine();
		int pCnt = 0; 
		int count = 0;
		
		char[] arr = S.toCharArray();

		
		for(int i = 1; i < arr.length - 1; i++) {
			if(arr[i - 1] == 'I' && arr[i] == 'O' && arr[i + 1] == 'I') {
				pCnt++;
				if(pCnt == N) {
					pCnt--;
					count++;
				}
				i++;
			}
			else {
				pCnt = 0;
			}
		}
		System.out.println(count);
	}
}