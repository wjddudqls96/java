import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[3];
        int max = Integer.MIN_VALUE;
        
        arr[0] = pattern1(answers);
        arr[1] = pattern2(answers);
        arr[2] = pattern3(answers);
        
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                list = new ArrayList<>();
                max = arr[i];
                list.add(i + 1);
            }
            else if(max == arr[i]){
                list.add(i + 1);
            }
        }
        System.out.println(list);
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    
    public int pattern1(int[] answers){
        int[] pick = {1, 2, 3, 4, 5};
        int cnt = 0;
        int number = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(pick[number++ % pick.length] == answers[i]){
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public int pattern2(int[] answers){
        int[] pick = {1, 3, 4, 5};
        int cnt = 0;
        int number = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(i % 2 == 0 && answers[i] == 2){
                cnt++;
            }
            else if(i % 2 == 1){
                if(answers[i] == pick[number++ % pick.length]){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public int pattern3(int[] answers){
        int[] pick = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt = 0;
        int number = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(pick[number++ % pick.length] == answers[i]){
                cnt++;
            }
        }
        
        return cnt;
    }
}