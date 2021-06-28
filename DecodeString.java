//time complexity:O(n)
//space complexity:O(l)
class Solution {
    public String decodeString(String s) {
        if(s==null||s.length()==0) return s;
        int num=0;
        StringBuilder currStr=new StringBuilder();
        Stack<Integer> numStack=new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            if(Character.isDigit(c))
            {
                num=num*10+c-'0';//add the number to num variable
            }
            else if(c=='[')
            {
                //if [ then push the num and curr str in the stacks
                //and reset the num and currStr
                numStack.push(num);
                strStack.push(currStr);
                num=0;
                currStr=new StringBuilder();
            }
            else if (c==']')
            {
                //if ] then pop the num stack and append the
                //string equal to the number popped from the stack
                int times=numStack.pop();
                StringBuilder newStr=new StringBuilder();
                for(int j=0;j<times;j++)
                {
                    newStr.append(currStr);
                }
                //append the child with the parent string
                StringBuilder parent=strStack.pop();
                currStr=parent.append(newStr); 
            }
            else
            {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
