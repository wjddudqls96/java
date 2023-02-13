import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N, K;
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
        	queue.add(i);
        }
        
        while(N > 0) {
        	for(int i = 0; i < K - 1; i++) {
        		queue.offer(queue.poll());
        	}
        	result.add(queue.poll());
        	N--;
        }
      
        sb.append("<");
        for(int i = 0; i < result.size(); i++) {
        	if(i == result.size() - 1) {
        		sb.append(result.get(i) + ">");
        	}
        	else {
        		sb.append(result.get(i) + "," + " ");
        	}
        	
        }
        System.out.println(sb);
    }
}