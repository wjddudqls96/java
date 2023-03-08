import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		BigInteger num1 = BigInteger.ONE;
		BigInteger num2 = BigInteger.ONE;
		
		for(int i = 0; i < M; i++) {
			num1 = num1.multiply(new BigInteger(String.valueOf(N - i)));
			num2 = num2.multiply(new BigInteger(String.valueOf(i + 1)));
		}
		
		System.out.println(num1.divide(num2));
	}
}