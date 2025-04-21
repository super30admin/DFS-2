class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder curStr = new StringBuilder();
        int curNum = 0;

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                curNum = curNum*10 + (c - '0');
            }

            else if(c == '[')
            {
                stringStack.push(curStr);
                numStack.push(curNum);

                curNum = 0;
                curStr = new StringBuilder();

            }

            else if( c == ']')
            {
                int count = numStack.pop();
                StringBuilder baby = new StringBuilder();
                for(int j = 0; j < count; j++){
                    baby.append(curStr);
                }
                StringBuilder parent = stringStack.pop();
                parent.append(baby);
                curStr = parent;
            }
            else
            {
                curStr.append(c);

            }

        }
        return curStr.toString();
        
    }
    
}