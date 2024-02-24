//TC: O(length of output string)

class Solution {
    public String decodeString(String s) {
        Stack<Integer> num=new Stack<>();
        Stack<StringBuilder> str=new Stack<>();
        int curr_num=0;
        StringBuilder curr_str=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            { 
                curr_num=curr_num*10+(c-'0');

            }
            else if(c=='[')
            {
                 num.push(curr_num);
                 str.push(curr_str);
                 curr_str=new StringBuilder();
                 curr_num=0;
            }
            else if (c==']')
            {
                int size=num.pop();
                StringBuilder new_str=new StringBuilder(curr_str);
                for(int j=0;j<size-1;j++)
                {
                  curr_str.append(new_str);
                }
                StringBuilder new1_str= new StringBuilder();
                new1_str=str.pop();
                curr_str=new1_str.append(curr_str);


            }
            else
            {
               curr_str.append(c);
            }
        }
        return curr_str.toString();
    }
}