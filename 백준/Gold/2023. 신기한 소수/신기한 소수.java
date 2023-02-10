import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		list = new ArrayList<>();
		int[] first = {2, 3, 5, 7};

		for(int i = 0; i < first.length; i++) {
			generate(first[i], 1);
		}
		
		for(int num : list) {
			sb.append(num).append("\n");
		}
		
		System.out.println(sb);
    }
	
	static void generate(int num, int count) {
		if(!isResult(num)) {
			return;
		}
		
		if(count == N) {
			list.add(num);
			return;
		}
		
		
		for(int i = 0; i <= 9; i++) {
			int result = (num * 10) + i;
			generate(result, count + 1);
		}
	}
	
	static boolean isResult(int num) {
		
		if(num < 2) {
			return false;
		}
		
		if(num == 2) {
			return true;
		}
		
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}