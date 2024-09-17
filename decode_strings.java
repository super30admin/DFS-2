//Time Complexity: O(N) where N is the length of the string
//Space Complexity: O(2N) = O(N) N being the length of the string 2 as we are using //2 stacks.

class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> numstack = new Stack<>();
        Stack<String> chstack = new Stack<>();
        int indx = 0;
        
        while(indx < s.length())
        {
            if(Character.isDigit(s.charAt(indx)))
            {
                int count = 0;
                while(Character.isDigit(s.charAt(indx)))
                {
                    count = count * 10 + (s.charAt(indx) - '0');
                    indx ++;
                }
                numstack.push(count);
            }
            
            else if(s.charAt(indx) == '[')
            {
                chstack.push(res);
                res = "";
                indx++;
            }
            
            else if(s.charAt(indx) == ']')
            {
                StringBuilder str = new StringBuilder(chstack.pop());
                int repeat = numstack.pop();
                for(int i=0;i<repeat;i++)
                {
                    str.append(res);
                }
                
                res = str.toString();
                indx++;
            }
            
            else
            {
                res = res + s.charAt(indx);
                indx++;
            }
        }
        return res;
    }
}