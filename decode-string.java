//TC: O(kN)
//SC: O(kN)
//Running on leetcode: yes
class Solution {
    public String decodeString(String s) {
        if (s==null || s.length()==0)
        {
            return s;
        }
        //two stack approach
        int num=0;
        //string builder
        StringBuilder currString = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        for (int i=0; i<s.length(); i++)
        {
            char c =s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            else if(c == '[') {
                numStack.push(num);
                strStack.push(currString);
                num = 0;
                currString = new StringBuilder();
            }
            else if(c == ']') {
                int times = numStack.pop();
                StringBuilder newString = new StringBuilder();
                for(int j = 0; j < times; j++) {
                    newString.append(currString);
                }
                currString = strStack.pop().append(newString);
            }
            else{
               currString.append(c); 
            }
        }
        return currString.toString();
    }
}
