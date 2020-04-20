// Time complexity: O(length of output string)
// Space complexity: O(length of given string)

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> strings = new Stack<>();
        
        int curr_num = 0;
        String curr_string = "";
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                curr_num = curr_num * 10 +(ch - '0');
            }
            else if(ch == '['){
                numbers.add(curr_num);
                strings.add(curr_string);
                
                curr_num = 0;
                curr_string = "";
            }
            else if(ch == ']'){
                int times = numbers.pop();
                
                StringBuilder process = new StringBuilder();
                for(int j = 0; j < times; j++){
                    process.append(curr_string);
                }
                
                curr_string = strings.pop() + process;
            }
            else{
                curr_string += ch;
            }            
        }
        
        return curr_string;
    }
}
