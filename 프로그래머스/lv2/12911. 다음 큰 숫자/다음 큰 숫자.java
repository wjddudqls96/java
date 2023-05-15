class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String binary = Integer.toBinaryString(n);
        
        
        int temp = -1;
        int count = 0;
        boolean flag = false;
        for(int i = binary.length() - 1; i >= 0 ; i--){
            if(binary.charAt(i) == '1' && !flag){
                temp = (1 << binary.length() - 1 - i);
                flag = true;
            }
            
            if(binary.charAt(i) == '1') count++;
        }
        
        binary = Integer.toBinaryString(Integer.parseInt(binary, 2) + temp);
        
        for(int i = binary.length() - 1; i >= 0 ; i--){
            if(binary.charAt(i) == '1') count--;
        }
        
        for(int i = 0; i < count; i++){
            int num = Integer.parseInt(binary, 2);
            binary = Integer.toBinaryString(num | (1 << i));
        }
       
        return Integer.parseInt(binary, 2);
    }
}