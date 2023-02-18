import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int[][] img;		// 흑백 이미지
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		img = new int[N][N];	
        
		for(int i = 0; i < N; i++) {
			String str = in.readLine();
			
			for(int j = 0; j < N; j++) {
				img[i][j] = str.charAt(j) - '0';
			}
		}
		
		QuadTree(0, 0, N);
		System.out.println(sb);
	}
	
	public static void QuadTree(int y, int x, int size) {
		
		// 압축이 가능할 경우 하나의 색상으로 압축해준다.
		if(isPossible(y, x, size)) {
			sb.append(img[y][x]);
			return;
		}
		
		int newSize = size / 2;	// 압축이 불가능 할 경우 사이즈를 절반으로 나누어야 한다.
		
		sb.append('(');	// 각 레벨(depth)에서 여는괄호로 시작해야한다. 
		
		QuadTree(y, x, newSize);						// 왼쪽 위
		QuadTree(y, x + newSize, newSize);				// 오른쪽 위
		QuadTree(y + newSize, x, newSize);				// 왼쪽 아래
		QuadTree(y + newSize, x + newSize, newSize);	// 오른쪽 아래
		
		sb.append(')');	// 해당 레벨이 끝나면 닫는괄호도 닫아준다.
			
		
	}
	
	
	// 압축이 가능한지 해당 공간을 체크해주는 함수
	public static boolean isPossible(int y, int x, int size) {
		int value = img[y][x];
		
		for(int i = y; i < y + size; i++) {
			for(int j = x; j < x + size; j++) {
				if(value != img[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}