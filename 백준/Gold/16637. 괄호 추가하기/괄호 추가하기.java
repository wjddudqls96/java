import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	static int N, max = Integer.MIN_VALUE;
	static ArrayList<Integer> numbers, operations;
	static boolean[] isSelected;
	static String[] inputs, temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		inputs = new String[N];
		numbers = new ArrayList<>();
		operations = new ArrayList<>();
		
		String line = in.readLine();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if(c == '+' || c == '*' || c == '-') {
				operations.add(i); 
			}
			else {
				numbers.add(i);
			}
			inputs[i] = Character.toString(line.charAt(i));
		}
		
		isSelected = new boolean[operations.size()];
		
		subSet(0);
		
		System.out.println(max);
	}
	
	static void subSet(int cnt) {
		if(cnt ==isSelected.length) {
			temp = Arrays.copyOf(inputs, inputs.length);
			for(int i = 0; i < isSelected.length; i++) {
				if(isSelected[i]) {
					int opIndex = operations.get(i);
					String op = temp[opIndex];  // 연산자
					String frontNum = temp[opIndex - 1]; // 앞숫자
					String backNum = temp[opIndex + 1]; // 뒷숫자
					
					int num = getOperation(frontNum, backNum, op);
					temp[opIndex - 1] = Integer.toString(num);
					temp[opIndex] = "";
					temp[opIndex + 1] = "";
				}
			}
			
			int result = Integer.parseInt(temp[0]);
			String type = "";
			
			for(int i = 1; i < temp.length; i++) {
				if(!temp[i].equals("")) {
					if(temp[i].equals("-") || temp[i].equals("+") || temp[i].equals("*")) {
						type = temp[i];
					}
					else {
						int num = getOperation(Integer.toString(result), temp[i], type);
						result = num;
					}
				}
			}
			
			if(max < result) {
				max = result;
			}
			return;
		}
		
		if(cnt > 0 && isSelected[cnt - 1]) {
			isSelected[cnt] = false;
			subSet(cnt + 1);
			return;
		}
		else {
			isSelected[cnt] = true;
			subSet(cnt + 1);
			isSelected[cnt] = false;
			subSet(cnt + 1);
		}
	}
	
	static int getOperation(String a, String b, String type) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		
		switch (type) {
		case "+":
			return num1 + num2;
		case "*":
			return num1 * num2;
		case "-":
			return num1 - num2;
		default:
			return Integer.MIN_VALUE;
		}
	}
}