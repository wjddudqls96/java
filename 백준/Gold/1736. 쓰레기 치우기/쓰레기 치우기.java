import java.util.*;
import java.io.*;

public class Main {
	static class MyScanner{
		BufferedReader bf;
		StringTokenizer st;
		
		MyScanner(){
			bf = new BufferedReader(new InputStreamReader(System.in));
			
			
		}
		
		String next() {
			if(st==null||!st.hasMoreTokens()) {
				
				try {
					st = new StringTokenizer(bf.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			return st.nextToken();
			
		}
		
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyScanner sc  = new MyScanner();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int map[][] = new int[N+1][M+1];
		PriorityQueue <Integer> pq[] = new PriorityQueue [M+1];
		int cnt = 0 ;
		for(int i =1 ;i<=M;i++) {
			pq[i] = new PriorityQueue <Integer>();
		}
		for(int i =1 ;i<=N;i++) {
			
			for(int j =1 ;j <=M;j++) {
				map[i][j]  = sc.nextInt();
				if(map[i][j]==1) { pq[j].add(i); cnt++;}
				
			}
		}
		
		
		int answer = 0;
		for(int i = M;i>=1;i--) { //M번 반복
			int pa = 0;
			int h = N;
			for(int j= M;j>=1;j--) {// 한칸씩 이동
				if(pq[j].size()==0) continue; //청소할게 없으면 이동
				int s = pq[j].peek();
				if(h>=s) {
					
					while(pq[j].size()>0&&h>=pq[j].peek()) { //청소할수있는 구역이면 우선순위 큐에서 pop
						pq[j].poll();
						pa++;
					}
					h=s; //H를 peek로 이동
				}
				
				
			}
			
			if(pa>0) answer++;
			if(pa==0) break; //더이상 청소할게 없음
		}
		
		System.out.println(answer);
		
		
		
	}

}