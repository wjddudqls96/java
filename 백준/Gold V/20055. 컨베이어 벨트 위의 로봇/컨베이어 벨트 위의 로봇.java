import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	private static int N, K;
	private static int[] belt;
	private static boolean[] robot;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[N * 2];
		robot = new boolean[N];
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < N * 2; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		
		while(true) {
			result++;
			
			moveBelt();
			moveRobot();
			loadRobot();
			
			if(isEnded()) {
				break;
			}
		}
		
		
		System.out.println(result);
		
	}
	
	static void moveBelt() {
		int tmp = belt[N * 2 - 1];
		for (int i = N * 2 - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		
		belt[0] = tmp;
		
		for (int i = N-1; i > 0; i--) {
			robot[i] = robot[i-1];
		}
		
		robot[0] = false;
		robot[N-1] = false;
	}
	
	static void moveRobot() {
		for (int i = N - 1; i > 0; i--) {
			if(robot[i - 1] && !robot[i] && belt[i] > 0) {
				robot[i - 1] = false;
				robot[i] = true;
				belt[i]--;
				robot[N - 1] = false;
			}
		}
	}
	
	static void loadRobot() {
		if(belt[0] > 0) {
			robot[0] = true;
			belt[0]--;
		}
	}
	
	static boolean isEnded() {
		int cnt = 0;
		
		for (int i = 0; i < N * 2; i++) {
			if(belt[i] == 0) cnt++;
		}
		
		if(cnt>=K) return true;
		
		return false;
	}
}