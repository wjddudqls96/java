import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(in.readLine());
		int count = 0;
		
		
		for(int i = 0; i <= 6; i++) {
			if((X & 1 << i) != 0) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}