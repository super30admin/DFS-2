class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strst = new Stack<>();
        StringBuilder curStr = new StringBuilder();
        int curNum=0;
        for(int i=0;i<s.length();i++)
        {
            char ch =s.charAt(i);
            if(Character.isDigit(ch))
            {
                curNum = curNum*10+ch-'0';
            }
            //we push the current number and cur string into their respective stacks when we encounter open brackets and make the cur Num and String 0 and empty
            else if(ch=='[')
            {
                numSt.push(curNum);
                strst.push(curStr);
                curNum=0;
                curStr = new StringBuilder();
            }
            //we pop the num from the number stack and then we make a curchild repeated with the num and then pop the char and appended with the child and make it as cur string.
            else if(ch==']')
            {
                    int cnt=numSt.pop();
                    StringBuilder child = new StringBuilder();
                    for(int k=0;k<cnt;k++)
                    {
                        child.append(curStr);
                    }
                    StringBuilder parent = strst.pop();
                     curStr = parent.append(child);
            }
            else{
                curStr.append(ch);
            }
        }
        return curStr.toString();
    }
}

//tc: O(n + m), where n is the length of the input string and m is the size of the decoded string, which could be up to O(n * k_max).
//sc:  O(n + m)
