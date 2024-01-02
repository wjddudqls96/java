import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
   
    static int [][] people;
    static int N;
    
    static int answer;
    static List<Integer> team1;
    static List<Integer> team2;
    
    public static void main(String[] args) throws Exception  {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N=Integer.parseInt(br.readLine());
        
        people=new int[N][N];
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                people[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        team1=new ArrayList<>();
        team2=new ArrayList<>();
        answer=Integer.MAX_VALUE;
        pickTeamWithBit();
        System.out.println(answer);
        
    }
    
    static void pickTeamWithBit(){
        for(int i=1;i<(1<<N)-1;i++) {
            
            for(int j=0;j<N;j++) {
                if((i & (1<<j))!=0) {    //해당 j번째 비트가 켜져있을 경우
                    team1.add(j);
                }else {                    //해당 j번째 비트가 꺼져있을 경우
                    team2.add(j);
                }
            }
            findAnswer();
            team1.clear();
            team2.clear();
        }
    }
    
    static void findAnswer() {
        int size1 =team1.size();
        int size2 =team2.size();
        
        int sum1=0;
        int sum2=0;
        
        for(int i=0;i<size1;i++) {
            for(int j=0;j<size1;j++) {
                if(i!=j) {
                    sum1+=people[team1.get(i)][team1.get(j)];
                }
            }
        }
        for(int i=0;i<size2;i++) {
            for(int j=0;j<size2;j++) {
                if(i!=j) {
                    sum2+=people[team2.get(i)][team2.get(j)];
                }
            }
        }
        
        answer=Math.min(answer, Math.abs(sum1-sum2));
        
    }
}