import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class Result{
	int countZ;
	int countO;
	
	public Result() {
		this.countO = -1;
		this.countZ = -1;
	}
	
	public Result(int countZ, int countO) {
		this.countO = countO;
		this.countZ = countZ;
	}
}

public class Main {
	static int N, M;
	static Result[] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < t; i++) {
			N = 0;
			M = 0;
			int num = Integer.parseInt(in.readLine());
			dp = new Result[num+1];
			Result result = fibonacci(num);
			
			sb.append(result.countZ + " " + result.countO).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static Result fibonacci(int n) {
        if (n == 0) {
        	return new Result(1, 0);
        }
        else if(n == 1) {
        	return new Result(0, 1);
        }
        else if (dp[n] != null)
            return dp[n];
        else {
        	Result a = fibonacci(n - 1);
        	Result b = fibonacci(n - 2);
        	
            return dp[n] = new Result(a.countZ + b.countZ, a.countO + b.countO);
        }
        	
 
    }
}