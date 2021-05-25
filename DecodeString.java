class Solution {
    //Time O(inner max string)
    //Space O(N)
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
        {
            return s;
        }
        Stack<Integer> Num_Stack = new Stack<>();
        Stack<StringBuilder> String_Stack = new Stack<>();
        int num = 0 ;
        StringBuilder currString = new StringBuilder();
        for(int i=0 ; i<s.length() ; i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num = num*10 + (c-'0');
            }
            else if(c == '[')
            {
                Num_Stack.push(num);
                String_Stack.push(currString);
                num = 0 ; currString = new StringBuilder();
            }
            else if(c == ']')
            {
                int temp = Num_Stack.pop();
                StringBuilder sb = new StringBuilder();
                for(int k=0 ; k<temp ; k++)
                {
                    sb.append(currString);
                }
                currString = String_Stack.pop().append(sb);
            }
            else
            {
                currString.append(c);
            }
        }
        return currString.toString();
    }
}