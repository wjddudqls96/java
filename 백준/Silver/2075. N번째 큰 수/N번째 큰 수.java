import java.io.*;
import java.util.*;

class Main {
    
	static int N,M;
    static int[][] map;
    
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(in.readLine());
        
        PriorityQueue<Long> queue = new PriorityQueue<Long>(Collections.reverseOrder());
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < N; j++){
                queue.offer(Long.parseLong(st.nextToken()));
            }
        }
        
        for(int i = 0; i < N - 1; i++){
            queue.poll();
        }
        
        System.out.println(queue.poll());
       
    }
}