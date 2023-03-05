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

class Charge{
	int x;
	int y;
	int c;
	int p;
	
	public Charge(int x, int y, int c, int p) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}
}

class Solution {
	static int M, A, result;
	static Charge[] charges;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringTokenizer st1 = null;
		StringTokenizer st2 = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			Pos posA = new Pos(0, 0);
			Pos posB = new Pos(9, 9);
			
			st1 = new StringTokenizer(in.readLine());
			st2 = new StringTokenizer(in.readLine());
			
			
			charges = new Charge[A];
			for(int i = 0; i < A; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				charges[i] = new Charge(x - 1, y - 1, c, p);
			}
			
			result = 0;
			getPossibleCharge(posA, posB);
			for(int i = 0; i < M; i++) {
				int num1 = Integer.parseInt(st1.nextToken());
				int num2 = Integer.parseInt(st2.nextToken());
				
				move(posA, num1, 1);
				move(posB, num2, 2);
				
				getPossibleCharge(posA, posB);
			}
			
			sb.append("#" + t + " " + result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void move(Pos pos, int dir, int count) {
		int[][] direction = {{0, 0},{0, -1},{1, 0},{0, 1},{-1, 0}};
		
		pos.x += direction[dir][0];
		pos.y += direction[dir][1];
		
	}
	
	static void getPossibleCharge(Pos posA, Pos posB) {
		boolean[] possibleA = new boolean[A];
		boolean[] possibleB = new boolean[A];
		
		for(int i = 0; i < A; i++) {
			Charge charge = charges[i];
			
			int distanceA = Math.abs(posA.x - charge.x) + Math.abs(posA.y - charge.y);
			int distanceB = Math.abs(posB.x - charge.x) + Math.abs(posB.y - charge.y);
			
			changePossible(possibleA, distanceA, charge.c, i);
			changePossible(possibleB, distanceB, charge.c, i);
			
			
		}
		
		int max = 0;
		for(int j = 0; j < A; j++) {
			for(int k = 0; k < A; k++) {
				int sum = 0;
				
				// 둘다 같이 있다면
				if(j == k && possibleA[j] && possibleB[k]) {
					sum += charges[j].p;
				}
				else {
					if(possibleA[j]) {
						sum += charges[j].p;
					}
					if(possibleB[k]) {
						sum += charges[k].p;
					}
				}
				
				if(max < sum) {
					max = sum;
				}
			}
		}
		
		result += max;
	}
	
	static void changePossible(boolean[] possible, int distance, int c, int index) {
		if(distance <= c) {
			possible[index] = true;
		}
	}
	
}