// Time Complexity : O(n) n is string length
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class decodeString {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack();
        Stack<String> str = new Stack();
        String currStr = "";
        int currnum = 0;
        for(int i=0;i<s.length();i++)
        {
           Character c = s.charAt(i);
            if(Character.isDigit(c))
            {
                //form number
                currnum = currnum*10+(c-'0');
            }
            else if(c=='[')
            {
                //Push existing number and string into respective stacks
                num.push(currnum);
                str.push(currStr);
                //Make the values empty
                currnum=0;
                currStr="";
            }
            else if(c==']')
            {
                StringBuilder newstring = new StringBuilder();
                //pop the number from stack as times 
                int times = num.pop();
                // newstring = times x currstring 
                for(int j=0;j<times;j++)
                {
                    newstring.append(currStr);
                }
                //finally pop str and assign to currstr
                currStr = str.pop();
                currStr+=newstring;
            }
            else{
                //form currStr
                currStr+=c;
            }
        }
        return currStr;
    }
}