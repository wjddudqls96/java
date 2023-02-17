import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] input, numbers;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		numbers = new int[7];
		input = new int[9];
		for(int i = 0 ; i < 9; i++) {
			input[i] = Integer.parseInt(in.readLine());
		}
		
		subSet(0, 0, 0);
		
	}
	
	static void subSet(int cnt, int start, int sum) {
		if(cnt == 7) {
			if(sum == 100) {
				for(int i = 0; i < numbers.length; i++) {
					System.out.println(input[numbers[i]]);
				}
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			numbers[cnt] = i;
			subSet(cnt + 1, i + 1, sum + input[i]);
		}
	}
}