class Solution {
    public String decodeString(String s) {
     Stack<Integer> numStack  = new Stack<Integer>();
     Stack<StringBuilder> stringStack = new Stack<>();
     StringBuilder curr = new StringBuilder();
     StringBuilder result = new StringBuilder();   
      int num = 0;
        for(char c : s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                num = num*10 + c-'0';
            }else if(c == '[')
            {
                numStack.push(num);
                stringStack.push(curr);
                curr = new StringBuilder();
                num  = 0;
                
            }else if(c == ']')
            {
                result = stringStack.pop();
                for(int i = numStack.pop();i>0;i--)
                {
                    result.append(curr);
                }
                curr = result;
            }else
            {
                curr.append(c);
            }
        }
        
        return curr.toString();
    }
}