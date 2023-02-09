import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class Pos implements Comparable<Pos>{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pos o) {
		if(o.y > this.y) {
			return -1;
		}
		else if(o.y == this.y) {
			if(this.x <= o.x) {
				return -1;
			}
			else {
				return 1;
			}
		}
		
		return 1;
	}
}

public class Main {
	static int N;
	static Pos[] map;
	static int MIN = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new Pos[N];
		for(int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			map[i] = new Pos(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		}
		
		Arrays.sort(map);
		
		int current = -1;
		int cnt = 0;
		for(Pos pos : map) {
			if(current <= pos.x) {
				cnt++;
				current = pos.y;
			}
		}
		
		System.out.println(cnt);
		
	}
}