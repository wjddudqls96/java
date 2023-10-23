import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Score {
	int score;
	int rank;
	
	public Score(int score, int rank) {
		this.score = score;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Score [score=" + score + ", rank=" + rank + "]";
	}
	
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		if(N != 0) {
			st = new StringTokenizer(in.readLine());
		}
		
		List<Score> list = new ArrayList<>();
		
		int rank = 0;
		int temp = -1;
		int count = 0;
		boolean find = false;
		
		for(int i = 0; i < N; i++) {
			int score = Integer.parseInt(st.nextToken());
			
			if(target > score) {
				if(target == temp) {
					list.add(new Score(target, list.get(i - 1).rank));
				}
				else {
					list.add(new Score(target, list.size() + 1));
				}
				find = true;
				break;
			}
			
			
			if(score == temp) {
				list.add(new Score(score, list.get(i - 1).rank));
			}
			else {
				list.add(new Score(score, list.size() + 1));
			}
			
			temp = score;
		}
		
		if(!find) {
			if(target == temp) {
				list.add(new Score(target, list.get(N - 1).rank));
			}
			else {
				list.add(new Score(target, list.size() + 1));
			}
		}
		
		if(list.size() > P) {
			System.out.println(-1);
		}
		else {
			System.out.println(list.get(list.size() - 1).rank);
		}
	}
}