
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] split = in.readLine().split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		int w = Integer.parseInt(split[2]);
		int h = Integer.parseInt(split[3]);
		int min = Integer.MAX_VALUE;
		
		min = x;
		min = min(min, y);
		min = min(min, w - x);
		min = min(min, h - y);
		
		System.out.println(min);
		
	}
	
	static int min(int min, int a) {
		if(min > a) {
			return a;
		}
		return min;
	}
	
}
