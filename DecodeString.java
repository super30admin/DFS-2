// Tine and space O(n) where n is the length of the  result string

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> s1= new Stack<>();
        Stack<Integer> s2= new Stack<>();
        StringBuilder currString = new StringBuilder();
        int currNum = 0;
        
        for( int i =0;i<s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch))
            {
                currNum = currNum*10 + (ch-'0');
            }
           else if(ch == '[')
            {
                s1.add(currString);
                s2.add(currNum);
                currString = new StringBuilder();
                currNum=0;
            }
           else if( ch == ']')
            {
                int val = s2.pop();
                StringBuilder parent = s1.pop();
                for(int j=0;j<val;j++)
                    parent.append(currString);
               currString = parent;
            }
            else
            {
                currString.append(ch);
            }
            
            
        }
        
        return currString.toString();
        
        
    }
}