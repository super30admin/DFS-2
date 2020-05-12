class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> number = new Stack<>();
        Stack<String> strings = new Stack<>();
        
        int curr_env_number = 0;
        String curr_env_string ="";
        
        for (int x = 0; x< s.length(); x++){
            
            Character ch = s.charAt(x);
            
            if(Character.isDigit(ch)){
                curr_env_number = curr_env_number * 10 + (ch - '0');
                
            } else if (ch == '['){
                number.push(curr_env_number);
                strings.push(curr_env_string);
                
                curr_env_number = 0;
                curr_env_string ="";
                
            } else if (ch == ']'){
                
                int times = number.pop();
                
                StringBuilder process = new StringBuilder();
                
                for (int y = 0; y < times; y++){
                    process.append(curr_env_string);
                }
                curr_env_string = strings.pop() + process;
                
            } else {
                curr_env_string +=ch;
            }
            
        }
        
        return curr_env_string;
        
    }
}