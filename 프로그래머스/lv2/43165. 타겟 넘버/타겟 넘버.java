class Solution {
    static int result;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        
        return result;
    }
    
    static void dfs(int cnt, int sum, int[] numbers, int target){
        if(cnt == numbers.length){
            if(target == sum){
                result++;
            }
            return;
        }
        
        dfs(cnt + 1, sum + numbers[cnt], numbers, target);
        dfs(cnt + 1, sum - numbers[cnt], numbers, target);
    }
}