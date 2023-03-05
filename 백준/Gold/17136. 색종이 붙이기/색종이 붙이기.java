import java.io.*;
import java.util.*;

public class Main {
	static int map[][] = new int[10][10];
	static int paper[] = {0,5,5,5,5,5};
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,0,0);
		
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else{
			System.out.println(ans);
		}
		
		
	}
	
	public static void dfs(int x, int y, int cnt) {
		
		if(x >= 9 && y >9) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(ans <= cnt) {	// ans보다 cnt가 크면 탐색할 필요 없음
			return;
		}
		
		if(y>9) {	// 가로줄 전부 봄. 아래 줄로 이동
			dfs(x+1,0,cnt);
			return;
		}
		
		if(map[x][y] ==1) {
			for(int i=5; i>=1; i--) {
				if(paper[i] >0 && check(x,y,i)) {	// 색종이가 남아있고, 붙일 수 있다면
					change(x,y,i,0);	// 색종이 붙임
					paper[i]--;
					dfs(x,y+1,cnt+1);
					change(x,y,i,1);	// 색종이 뗌
					paper[i]++;
				}
			}
		}else {	// 오른쪽으로 이동
			dfs(x,y+1, cnt);
		}
	}
	
	/* 상태를 바꾸는 함수. 0->1, 1->0 */
	public static void change(int x, int y, int size, int state) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j <y+size; j++) {
				map[i][j] = state;
			}
		}
	}
	
	/* 색종이를 붙일수 있는지 체크하는 함수 */
	public static boolean check(int x, int y, int size) {
		for(int i=x; i<x +size; i++) {
			for(int j=y; j< y+size; j++) {
				if(i<0 || i>=10 || j<0 || j >=10) {	// 범위 벗어남
					return false;
				}
				
				if(map[i][j] != 1) {	// 1이 아님
					return false;
				}
			}
		}
		return true;
	}
}