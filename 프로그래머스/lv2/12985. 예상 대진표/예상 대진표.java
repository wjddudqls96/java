import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        while(true){
            if(min + 1 == max && min % 2 == 1){
                break;
            }
            
            min = play(min);
            max = play(max);
            answer++;
        }

        // System.out.println(cnt);

        return answer;
    }
    
    static int play(int num){
        if(num <= 2){
            return 1;
        }
        else{
            if(num % 2 == 0){
                return num / 2 ;
            }
            else{
                return num / 2 + 1;
            }
        }
    }
}