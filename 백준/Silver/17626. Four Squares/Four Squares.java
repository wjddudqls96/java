import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        
        int dp[] = new int[N+1];
        for(int i=1; i<dp.length; i++) {
            dp[i] = dp[i-1] +1;
            for(int j=1; j*j<=i; j++)
                dp[i] = Math.min(dp[i], dp[i - j*j]+1);
        }
        System.out.println(dp[dp.length-1]);
    }
}