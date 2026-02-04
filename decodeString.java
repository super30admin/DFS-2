/**
TC: O(n)
SC: O(n) n: lenght of string s
Approach: keep on pushing chars into the stack until i see ']', once ']' i will pop until i see '[', now to get the number i will keep on popping until the top of stack is not digit. now, just create a string by reprating the string built times the num created from popping, push back to the stack. return the values in stack.
 */

class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        for(int i =0; i< s.length(); i++){
           char ch = s.charAt(i);

            if(ch != ']')   
                st.push(String.valueOf(ch));
            else{
                StringBuilder sb = new StringBuilder();

                while(!st.peek().equals("["))
                 sb.insert(0,st.pop());
                
                st.pop();

                StringBuilder num = new StringBuilder();

                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0)))
                    num.append(st.pop());
                
                num.reverse();

                st.push(sb.toString().repeat(Integer.parseInt(num.toString())));
            }
        }
         return String.join("",st);
    }
}