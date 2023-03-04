import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + "]";
	}
	
	
}

class Solution {
	static int K;
	static ArrayList<LinkedList<Integer>> list;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			K = Integer.parseInt(in.readLine());
			list = new ArrayList<>();
			
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(in.readLine());
				LinkedList<Integer> link = new LinkedList<>();
				for(int j = 0; j < 8; j++) {
					link.add(Integer.parseInt(st.nextToken()));
				}
				list.add(link);
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				
				int index = Integer.parseInt(st.nextToken());
				int type = Integer.parseInt(st.nextToken());
				
				int[] input = getPossible(type, index - 1);
				generate(input);
			}
			
			
			int result = 0;
			for(int i = 0; i < 4; i++) {
				List<Integer> l = list.get(i);
				
				if(l.get(0) == 1) {
					result += 1 << i;
				}
			}
			
			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb);
	}
	
	static int[] getPossible(int type, int index) {
		int[] input = new int[4];
		int left = list.get(index).get(list.get(index).size() - 2);
		int right = list.get(index).get(2);
		boolean isOdd = index % 2 == 0 ? true : false;
		input[index] = type;
		
		// 투포인터 왼쪽
		int count = 0;
		for(int i = index - 1; i >= 0; i--) {
			List<Integer> l = list.get(i);
			
			if(left != l.get(2)) {
				if(count % 2 == 0) {
					input[i] = -type;
				}
				else {
					input[i] = type;
				}
			}
			else {
				break;
			}
			
			left = l.get(l.size() - 2);
			count++;
		}
		
		// 오른쪽
		count = 0;
		for(int i = index + 1; i < 4; i++) {
			List<Integer> l = list.get(i);
			
			if(right != l.get(l.size() - 2)) {
				if(count % 2 == 0) {
					input[i] = -type;
				}
				else {
					input[i] = type;
				}
			}
			else {
				break;
			}
			
			right = l.get(2);
			count++;
		}

		return input;
	}
	
	static void generate(int[] input) {
		for(int i = 0; i < 4; i++) {
			int num = input[i];
			List<Integer> l = list.get(i);
			
			if(num == 0) continue;
			
			if(num == 1) {
				int temp = l.get(7);
				l.remove(7);
				l.add(0, temp);
			}
			else if(num == -1){
				int temp = l.get(0);
				l.remove(0);
				l.add(temp);
			}
		}
	}

}