//Time Complexity: length of the string
//Space Complexity: O(1)

class Solution {
    public String decodeString(String s) {
        Stack<Integer> num_stack = new Stack<>();
        Stack<String> string_stack = new Stack<>();
        int num =0; String current_string = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c - '0';

            }
            else if(c == '['){
                num_stack.push(num);
                string_stack.push(current_string);
                num=0;
                current_string = "";
            }
            else if(c==']'){
                int count = num_stack.pop();
                String baby = "";
                for(int k=0; k<count; k++){
                    baby = baby+current_string;
                }
                current_string = string_stack.pop() + baby;
            }
            else{
                current_string = current_string + c;
            }
        }
        return current_string;
    }
}
