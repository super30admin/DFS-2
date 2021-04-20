/*
Thought Process: 
Use a num stack to store the numbers and string stack to store previous strings. Loop through each character. 
If it is a digit, calculate num
Else if it is [ , push the curr string to string stack and num to num stack. Reset both of them.
Else if it is ] , store temp curr, pop num, repeat the curr to add temp num-1 times
else append current char to curr.

TC -> O(N) where N is number of employees
SC -> O(N) size of either stack which will be maximum N in worst case
*/

class DecodeString {
    public String decodeString(String s) {
        String curr= "";
        if(s == null || s.length() == 0) return curr;
        
        Stack<String> strStack = new Stack();
        Stack<Integer> numStack = new Stack();
        
        int num = 0;
        
        for(int i = 0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + Integer.parseInt(String.valueOf(ch));
            }
            else if(ch == '['){
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr ="";
            }
            else if(ch == ']'){
                int numPopped = numStack.pop();
                String tempCurr = curr;
                for(int j=0; j<numPopped-1; j++)
                    curr += tempCurr;
                if(!strStack.isEmpty()){
                    curr = strStack.pop() + curr;
                }
            }
            else curr += ch;
        }
        return curr;
    }
}