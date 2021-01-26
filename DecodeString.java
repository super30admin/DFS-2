// Time Complexity : 0(n*K) n=len(s) k=max(all numbers) bcoz we are running internal loop to multiply currStr
// Space Complexity : 0(n) worst case scenario where almost all digits
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was not able to think of solution using stack. Tried to do the recurssion way

class DecodeString {
    int index = 0;
    public String decodeString(String s) {
        if(s == null)
            return null;

        //string stack and number stack
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        int num = 0;
        StringBuilder currStr = new StringBuilder();

        //iterating through the string
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //if num then keep track of overall num (might be 2-3 digit of num)
            if(Character.isDigit(c)){
                num = num*10 + Character.getNumericValue(c);
            }
            //when [ is encountered, push num & currStr in stacks & reinitialize
            else if(c == '['){
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            }
            //when ] is encountered, multiply currStr
            else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                int times = numStack.pop();
                for(int j=0;j<times;j++){
                    tmp.append(currStr);
                }
                //take out previous str from stack & attach back multiplied currStr
                currStr = strStack.pop();
                currStr.append(tmp);
            }
            else{
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}