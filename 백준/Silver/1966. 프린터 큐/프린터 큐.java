import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Paper{
	int prior;
	boolean isSelect;
	
	public Paper(int prior, boolean isSelect) {
		this.prior = prior;
		this.isSelect = isSelect;
	}
}

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(in.readLine());
    	
    	for(int testCase = 0; testCase < T; testCase++) {
    		String[] split = in.readLine().split(" ");
        	
        	int N = Integer.parseInt(split[0]);
        	int M = Integer.parseInt(split[1]);
        	
        	String[] line = in.readLine().split(" ");
        	Queue<Paper> queue = new LinkedList<Paper>();
        	List<Integer> list = new ArrayList<Integer>();
        	
        	for(int i = 0; i < N; i++) {
        		Paper paper = null;
        		if(i == M) {
        			paper = new Paper(Integer.parseInt(line[i]), true);
        		}else {
        			paper = new Paper(Integer.parseInt(line[i]), false);
        		}
        		queue.add(paper);
        		list.add(Integer.parseInt(line[i]));
        	}
        	Collections.sort(list, Collections.reverseOrder());
        	
        	
        	
        	int count = 1;
        	int index = 0;
        	while(!queue.isEmpty()) {
        		Paper paper = queue.poll();
        		
        		if(paper.isSelect && paper.prior == list.get(index)) {
        			break;
        		}
        		
        		if(paper.prior == list.get(index)) {
        			index++;
        			count++;
        			continue;
        		}
        		
        		queue.add(paper);
        	}
        	
        	System.out.println(count);
    	}
    }
}