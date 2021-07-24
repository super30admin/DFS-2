class Solution {
    public String decodeString(String s) {

        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> numb = new Stack<>();
        StringBuilder currstr = new StringBuilder();
        int num = 0;

        for(int i=0 ; i<s.length() ; i++)
        {

            if(Character.isDigit(s.charAt(i)))
            {
                num = num*10 + (s.charAt(i)-'0');
            }

            else if(s.charAt(i) == '[')
            {
                numb.add(num);
                str.add(currstr);
                num = 0;
                currstr = new StringBuilder();
            }

            else if(s.charAt(i) == ']')
            {
                int rep = numb.pop();
                StringBuilder parent = str.pop();

                StringBuilder newstr = new StringBuilder();

                for(int j=0 ; j<rep ; j++)
                {
                    newstr.append(currstr);
                }

                currstr = parent.append(newstr);

            }

            else
            {
                currstr.append(s.charAt(i));
            }
        }

        return currstr.toString();
    }
}
