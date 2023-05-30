class Solution {
    public int[] solution(String s) {
        int remove = 0;
        int repeat = 0;
        
        while(!s.equals("1")){
            int cnt = 0;
            
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1') cnt++;
                else remove++;
            }
        
            s = Integer.toBinaryString(cnt);
            repeat++;
        }
        
        int[] answer = {repeat, remove};
        
        return answer;
    }
}