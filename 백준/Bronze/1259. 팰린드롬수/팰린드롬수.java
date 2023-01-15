

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while(!(str = in.readLine()).equals("0")) {
			boolean isPalindrom = true;
			for(int i = 0; i < str.length() / 2; i++) {
				int point1 = i;
				int point2 = str.length() - 1 - i;
				if(str.charAt(point1) != str.charAt(point2)) {
					isPalindrom = false;
				}
			}
			if(isPalindrom) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
		}
		System.out.println(sb);
	}
}
