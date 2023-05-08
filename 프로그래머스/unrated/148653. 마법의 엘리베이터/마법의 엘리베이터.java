class Solution {
    public int solution(int storey) {
        return elevator(storey);
    }
    
    public int elevator(int storey) {
        
        if(storey <= 1) {
            // 무한루프 방지
            return storey;
        }
        
        int divide = storey/10;
        int left = storey%10;
        
        // 바로 아래 10의 보수 단위 층까지 이동 후 1층씩 올라가기.
        // 예를 들어 121층이면 120층 까지 이동 후 1층 올라가기.
        int goUp = left + elevator(divide);
        
        // 바로 위 10의 보수 단위 층까지 이동 후 1층씩 내려가기.
        // 예를 들어 129층이면 130층 까지 이동 후 1층 내려가기.
        int goDown = (10-left) + elevator(divide + 1);
        
        return Math.min(goUp, goDown);
    }
}