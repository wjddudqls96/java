import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	 static StringBuilder sb = new StringBuilder();
	    static long T, N, R, P, ans, X, Y;
	    static String[] ss;
	    static long[] factorial;
	    
	    public static void main(String[] args) throws Exception {
	        
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        T = Integer.parseInt(in.readLine());
	        
	        for(int tc = 1; tc <= T; tc++) {
	            ss = in.readLine().split(" ");
	            N = Long.parseLong(ss[0]);
	            R = Long.parseLong(ss[1]);
	            P = Long.parseLong(ss[2]);
	            
	            factorial = new long[100000 + 2];
	            factorial[0] = 1;
	            for(int i = 1; i <= P; i++) {
	                factorial[i] = (i * factorial[i - 1]) % P;
	            }
	            
	            ans = 1;
	            while(R > 0 || N > 0) {
	                X = N % P;
	                Y = R % P;
	                if(Y > X) {
	                    ans = 0;
	                    break;
	                }
	                
	                ans = (ans * factorial[(int) X]) % P;
	                for(int i = 0; i < P - 2; i++) {
	                    ans = (ans * factorial[(int) (X-Y)] * factorial[(int) Y]) % P;
	                }
	                
	                N /= P;
	                R /= P;
	            }
	            ans %= P;
	            sb.append("#" + tc + " " + ans + '\n');
	        }
	        System.out.println(sb);
	    }
}