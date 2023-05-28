import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start = 0;
        
        
        for(int i = people.length - 1; start <= i; i--){
            if(people[start] + people[i] <= limit) start++;
            answer++;
        }
        return answer;
    }
}