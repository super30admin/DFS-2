// Time Complexity : O(n)
// Space Complexity : (n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class DecodeString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;

        //one stack for letter, one for num
        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;
        //loop thru given string
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //get curr num
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            //add num and character to respective stacks
            else if(c == '['){
                st.push(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder();
            }
            //repeat letter based on corresponding num, add to curr
            else if(c == ']'){
                int times = st.pop();
                StringBuilder newStr = new StringBuilder();

                for(int j = 0; j < times; j++){
                    newStr.append(curr);
                }
                curr = strStack.pop().append(newStr);
            }
            else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}