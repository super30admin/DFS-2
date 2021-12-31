// Time Complexity: O(max number * n)
// Space Complexity: O(n)
// Stack
public class DecodeString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        Stack<Integer> noStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        StringBuilder currStr = new StringBuilder();
        int no = 0;
        
        for(char c : s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                no = no * 10 + (c -'0');
            }
            else if(c == '[')
            {
                noStack.push(no);
                strStack.push(currStr);
                // reset no and string back to zero
                no = 0;
                currStr = new StringBuilder();
            }
            else if (c == ']')
            {
                int times = noStack.pop();
                // since in java we cannot multiply string we will have to create a new string
                StringBuilder newStr = new StringBuilder();
                while(times > 0)
                {
                    newStr.append(currStr);
                    times--;
                }
                // append inner evaluated string to old string in stack
                // as a new string that need to be evaluted
                sb = strStack.pop().append(newStr);
            }
            else
            {
                currStr.append(c);
            }
        }
        
        return currStr.toString(); 
    }
}
// Time Complexity: O(max number * n)
// Space Complexity: O(n)
// DFS
public class DecodeString {
    // so that index of i can be used across all recursive calls
    int i = 0 ;
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
            return "";
        int no = 0 ;
        StringBuilder currStr = new StringBuilder();
        while (i < s.length())
        {
            char c = s.charAt(i);
            // move i ahead
            i++;
            if(Character.isDigit(c))
            {
                no = no * 10 + (c-'0');
            }
            else if(c == '[')
            {
                // evaluate inner expression
                String returnedStr = decodeString(s);
                // multiply inner expression with the no of time before evaluating
                StringBuilder newStr = new StringBuilder(); 
                while(no > 0 )
                {
                    newStr.append(returnedStr);
                    no--;
                }
                // append so that it will help nested bracket scenario
                currStr.append(newStr);
            }
            else if(c == ']')
            {
                return currStr.toString();
            }
            else
            {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}