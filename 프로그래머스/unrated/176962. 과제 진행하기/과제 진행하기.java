import java.util.*;

class Plan implements Comparable<Plan>{
    String name;
    int time;
    int playTime;
    
    Plan(String name, String start, String playTime){
        String[] split = start.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        
        this.name = name;
        this.time = minute + (hour * 60);
        this.playTime = Integer.parseInt(playTime);
    }
    
    @Override
    public int compareTo(Plan o1){
        return this.time - o1.time;
    }
    
    @Override
    public String toString(){
        return this.name + " " + this.time + " " + this.playTime;
    }
}

class Solution {
    static List<Plan> list;
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        list = new ArrayList<>();
        for(int i = 0; i < plans.length; i++){
            String name = plans[i][0];
            String start = plans[i][1];
            String playTime = plans[i][2];
            
            list.add(new Plan(name, start, playTime));
        }
        
        Collections.sort(list);
        
        Stack<Plan> remainPlans = new Stack<>();
        List<String> endPlan = new ArrayList<>();
        int curTime = list.get(0).time;
        int i = 0;
        
        while(true){
        
            if(i == list.size()) break;
            
            Plan cur = list.get(i);
            // 시간이 남아있다면.
            if(curTime < cur.time && !remainPlans.isEmpty()){
                Plan pastPlan = remainPlans.pop();
                
                // 일을 다 할 수 있다면
                if(curTime + pastPlan.playTime <= cur.time){
                    endPlan.add(pastPlan.name);
                    curTime = curTime + pastPlan.playTime;
                }
                else{
                    pastPlan.playTime -= (cur.time - curTime);
                    curTime = cur.time;
                    remainPlans.push(pastPlan);
                }
                
                continue;
            }
            
            // 일이 다음꺼전에 끝난다면
            if(i + 1 < list.size() && cur.time + cur.playTime <= list.get(i + 1).time){
                curTime = cur.time + cur.playTime;
                endPlan.add(cur.name);
            }
            // 일이 다음꺼전에 끝나지 않는다면
            else if(i + 1 < list.size()){
                cur.playTime -= (list.get(i + 1).time - cur.time);
                curTime = list.get(i + 1).time;
                remainPlans.push(cur);
            }
            else if(i +1 == list.size()){
                curTime = cur.time + cur.playTime;
                endPlan.add(cur.name);
            }
            
            i++;
        }
        
        
        while(!remainPlans.isEmpty()){
            endPlan.add(remainPlans.pop().name);
        }
        
        for(int j = 0; j < endPlan.size(); j++){
            answer[j] = endPlan.get(j);
        }
        
        return answer;
    }
}