//Time Complexity=O(n)
//Space Complexity=O(n)
class Solution {
    public String decodeString(String s) {
        Stack<String>stack1=new Stack();
        Stack<Integer>stack2=new Stack();
        int curNum=0;
        String curStr="";
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                curNum=curNum*10+(c-'0');
            }
            else if(c=='[')
            {
                stack1.push(curStr);
                stack2.push(curNum);
                curStr="";
                curNum=0;
            }
            else if(c==']'){
                int number=stack2.pop();
                String temp="";
                for(int j=0;j<number;j++)
                {
                    temp=temp+curStr;
                }
                curStr=stack1.pop()+temp;
                
            }
            else{
                curStr=curStr+c;
            }
        }
        return curStr;
    }
}