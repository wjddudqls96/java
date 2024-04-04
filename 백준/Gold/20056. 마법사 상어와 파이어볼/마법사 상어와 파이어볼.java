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

class FireBall {
	int weight;
	int speed;
	int dir;
	
	public FireBall(int weight, int speed, int dir) {
		this.weight = weight;
		this.speed = speed;
		this.dir = dir;
	}
}

public class Main {
	private static int N, M, K;
	private static List<FireBall>[][] map, temp;
	private static int[][] dir = {{0, -1},{1, -1},{1, 0},{1, 1},{0, 1},{-1, 1},{-1, 0},{-1, -1}};
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("./input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N][N];
		temp = new ArrayList[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
				temp[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[r][c].add(new FireBall(m, s, d));
		}
		
		
		for(int k = 0; k < K; k++) {
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(FireBall fireBall : map[i][j]) {
						move(j, i, fireBall);
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j].clear();
					List<FireBall> newList = new ArrayList<>();
					
					if(temp[i][j].size() > 1) {
						// 합쳐지는 로직 + 4개의 파이어볼 생성 로직.
						newList = combiAndSplit(temp[i][j]);
					}
					else {
						for(FireBall f : temp[i][j]) {
							newList.add(f);
						}
					}
					
					if(newList != null) {
						map[i][j] = newList;
					}
					
					temp[i][j].clear();
				}
			}
		}
		
		int result = 0;
		
		for(List[] listArr : map) {
			for(List<FireBall> list : listArr) {
				for(FireBall fireBall : list) {
					result += fireBall.weight;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static void move(int x, int y, FireBall fireBall) {
		int nextX = (x + dir[fireBall.dir][0] * fireBall.speed % N + N) % N;
        int nextY = (y + dir[fireBall.dir][1] * fireBall.speed % N + N) % N;
		
		temp[nextY][nextX].add(fireBall);
	}
	
	static List<FireBall> combiAndSplit(List<FireBall> list) {
		List<FireBall> newList = new ArrayList<>();
		int[] dir1 = {0,2,4,6};
		int[] dir2 = {1,3,5,7};
		int weightSum = 0;
		int speedSum = 0;
		
		for(int i = 0; i < list.size(); i++) {
			weightSum += list.get(i).weight;
			speedSum += list.get(i).speed;
		}
		
		int weight = weightSum / 5;
		int speed = speedSum / list.size();
		int prev = list.get(0).dir % 2;
		boolean isSame = true;
		
		if(weight == 0) {
			return newList;
		}
		
		int firstDirMod = list.get(0).dir % 2; // 첫 번째 파이어볼의 방향(짝수/홀수) 저장

		for (FireBall fireBall : list) {
		    if (fireBall.dir % 2 != firstDirMod) { // 첫 번째 파이어볼과 다른 짝수/홀수 패턴을 가진 파이어볼이 있는지 확인
		        isSame = false;
		        break;
		    }
		}
		
		for(int i = 0; i < 4; i++) {
			if(isSame) {
				newList.add(new FireBall(weight, speed, dir1[i]));
			}
			else {
				newList.add(new FireBall(weight, speed, dir2[i]));
			}
		}
		
		return newList;
	}
}