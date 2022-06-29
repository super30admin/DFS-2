class Solution {
    public String decodeString(String s)
    {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();

        StringBuffer currentBuffer = new StringBuffer();
        int currentValue = 0;

        for(int i  =0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                currentValue = currentValue * 10 + (ch - '0');
            }
            else if(ch == '[') {
                stringStack.push(currentBuffer.toString());
                integerStack.push(currentValue);

                currentBuffer.setLength(0);
                currentValue = 0;
            }
            else if(ch == ']') {

                int reps = integerStack.pop();
                StringBuffer sb = new StringBuffer();
                while (reps >0)
                {
                    sb.append(currentBuffer);
                    reps--;
                }

                String currentString = sb.toString();
                String parentValue = stringStack.pop();

                currentBuffer.setLength(0);
                currentBuffer.append(parentValue + currentString);

            }
            else {
                currentBuffer.append(ch);
            }
        }


        return currentBuffer.toString();
    }
}