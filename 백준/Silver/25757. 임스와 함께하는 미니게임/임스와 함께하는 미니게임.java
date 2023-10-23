import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String type = st.nextToken();
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			set.add(in.readLine());
		}
		
		int result = 0;
		switch (type) {
			case "Y":
				result = set.size();
				break;
			case "F":
				result = set.size() / 2;
				break;
			case "O":
				result = set.size() / 3;
				break;
		}
		
		System.out.println(result);
	}
}