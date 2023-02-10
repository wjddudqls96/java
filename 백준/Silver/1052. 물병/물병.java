import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	static int N, K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        while (true) {
            char[] binary = Integer.toBinaryString(N).toCharArray();
            int cnt = 0;

            for (int i = 0; i < binary.length; i++) if (binary[i] == '1') cnt++;

            if (cnt <= K) {
                System.out.println(answer);
                break;
            }

            N++;
            answer++;
        }
    }
}