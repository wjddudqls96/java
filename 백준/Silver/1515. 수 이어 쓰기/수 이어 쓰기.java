import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String line = in.readLine();
		
		int num = 0;
		int index = 0;
		
		while (true) {
			num++;
			String numStr = String.valueOf(num);
			boolean flag = false;
			
			for(int i = 0; i < numStr.length(); i++) {
				if(numStr.charAt(i) == line.charAt(index)) {
					index++;
				}
				
				if(index == line.length()) {
					flag = true;
					break;
				}
			}
			
			if(flag) break;
		}
		
		System.out.println(num);
	}
}