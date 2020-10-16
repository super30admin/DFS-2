// Time Complexity : O(maxNum*max(stbstr_len)), This would be of the order of n[substr] number(n)*len(substr), as we form and pushback to stack
// Space Complexity : O(maxNum*max(stbstr_len)), same as above as we push the substr back onto the stack repeatedly
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Did not get intuition initially
// formed subStr using StringBuilder by inserting at 0

// Your code here along with comments explaining your approach
// This approach is a single stack approach to the problem
// iterate over given string, if char !=']' push chars to stack till that point
// else need to decode cur string, pop currently seens chars from stack, form tempString
// then pop numbers to make numeric part
// duplicate tempString and then pushback onto the stack
// process next chars in the main string
// repeat till we reach end of given string
// create char[] to form resulting string and return the result as a string

class Solution {
    Stack<Character> stack = new Stack<Character>();
    
    private void decodeTempStringAndPushbackToStack(){
        ArrayList<Character> temp = new ArrayList<Character>();
        
        while(stack.peek()!='['){
            temp.add(stack.pop());
        }
        //remove '[' char
        stack.pop();
        int n = parseNumFromTopOfStack();
        
        while(n>0){
            for(int i=temp.size()-1; i>=0; i--){
                stack.push(temp.get(i));
            }
            n--;
        }
    }
    
    private int parseNumFromTopOfStack(){
        int n = 0;
        int place = 1;
        while(!stack.empty() && Character.isDigit(stack.peek())){
            n = Character.getNumericValue(stack.pop())*place + n;
            place *= 10;
        }
        
        return n;
    }
    
    public String decodeString(String s) {
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=']'){
                stack.push(s.charAt(i));
            }
            else{
                decodeTempStringAndPushbackToStack();
            }
        }
        
        char[] resultCharArray = new char[stack.size()];
        
        for(int i=stack.size()-1; i>=0; i--){
            resultCharArray[i] = stack.pop();
        }
        
        String result = new String(resultCharArray);
        return result;
    }
}

