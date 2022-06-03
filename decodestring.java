//Time Complexity : O(output string.length()) here output string is namedd as current string
//Space Complexity : O(n) n -> lenght of s
//Approach : DFS
//did your code run on leetcode : yes

class Solution {
    public String decodeString(String s) {
        StringBuilder currentStr = new StringBuilder();
        
        if(s == null || s.length() == 0) return "";
        int num = 0;
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        //we need to traverse the string s
        for(int i = 0; i < s.length(); i++)
        { 
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
               num = num * 10 + (c - '0'); //getting ascii value  
            }
            else if(c == '[')
            {   //abandon parent inside recursive stack and go to the baby
                strStack.push(currentStr);
                numStack.push(num);
                currentStr = new StringBuilder();
                num = 0;
                
            }
            else if(c == ']')
            {
                StringBuilder temp_string = new StringBuilder();
                int decode_count = numStack.pop();
                //decoding child
                for(int d = 0; d < decode_count; d++){
                    temp_string.append(currentStr);
                }
                //combining parent with decoded child
                StringBuilder parent = strStack.pop();
                currentStr = parent.append(temp_string);
            }
            //letter
            else
            {
                currentStr.append(c);
            }
            
        }
        return currentStr.toString();
        
    }
}
