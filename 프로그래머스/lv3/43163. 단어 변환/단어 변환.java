class Solution {
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        dfs(0, begin, target, words);
        
        if(min == Integer.MAX_VALUE){
            min = 0;
        }
        
        return min;
    }
    
    static void dfs(int dept, String curStr, String target, String[] words){
        
        if(dept == words.length){
            return;
        }
        
        if(dept >= min){
            return;
        }
        
        if(curStr.equals(target)){
            if(min > dept){
                min = dept;
            }
        }
        
        for(int i = 0; i < words.length; i++){
            String nextStr = words[i];
            
            if(visited[i]) continue;
            
            // 바꿀수 있다면
            if(isChangeable(curStr, nextStr)){
                visited[i] = true;
                dfs(dept + 1, nextStr, target, words);
                visited[i] = false;
            }
        }
    }
    
    static boolean isChangeable(String str1, String str2){
        int cnt = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(i)){
                cnt++;
            }
        }
        
        return cnt == str1.length() - 1;
    }
}