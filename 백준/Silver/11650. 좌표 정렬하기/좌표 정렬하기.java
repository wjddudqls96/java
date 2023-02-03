import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pos implements Comparable<Pos>{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Pos p) {
		if(this.x > p.x) {
			return 1;
		}
		else if(this.x == p.x) {
			return this.y - p.y;
		}
		else {
			return -1;
		}
	}
	
}

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(in.readLine());
    	List<Pos> list = new ArrayList<Pos>();
    	
    	for(int i = 0; i < N; i++) {
    		String[] line = in.readLine().split(" ");
    		int x = Integer.parseInt(line[0]);
    		int y = Integer.parseInt(line[1]);
    		
    		list.add(new Pos(x, y));
    		
    	}
    	
    	Collections.sort(list);
    	
    	for(Pos pos : list) {
    		System.out.println(pos.x + " " + pos.y);
    	}

    }
}