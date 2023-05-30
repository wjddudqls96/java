import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int lcm = arr[arr.length - 1];
        System.out.println(lcm);
        while(true){
            int cnt = 0;
            
            for(int i = 0; i < arr.length - 1; i++){
                if(lcm % arr[i] == 0) cnt++;
                else break;
            }
            
            if(cnt == arr.length - 1) break;
            lcm += arr[arr.length - 1];
        }
        
        return lcm;
    }
}