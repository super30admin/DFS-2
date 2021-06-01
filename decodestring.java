class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
        {
            return s;
        }
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> stng = new Stack<>();
        int numdigit = 0;
        StringBuilder currentstr = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
               numdigit = numdigit * 10 + ch - '0';
            }
            else if(ch == '[')
            {
                nums.add(numdigit);
                stng.add(currentstr);
                numdigit = 0;
                currentstr = new StringBuilder();
            }
            else if(ch == ']')
            {
                int repeat = nums.pop();
                StringBuilder tempstr = new StringBuilder();
                for(int j = 0; j < repeat; j++)
                {
                    tempstr = tempstr.append(currentstr);
                }
                currentstr = stng.pop().append(tempstr);
            }
            else
            {
                currentstr = currentstr.append(ch);
            }
        }
        return currentstr.toString();
    }
}
