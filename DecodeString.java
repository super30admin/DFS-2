class Solution {
    //tc:product of all integres* size of string
    //sc:

    private int i=0;
    private String s;
    public String decodeString(String s) {
        i=0;
        this.s = s;
        return decodeString();


    }
    private String decodeString()
    {
        int num =0;
        String res="";
        String currStr="";
        while(i < s.length())
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                num = num*10 + (ch-'0'); // converting string to num
                ++i;
            }
            else if (ch == '[')
            {
                //dfs recursion
                ++i;
                String repeatStr = decodeString();

                for(int j = 0 ; j < num ; ++j)
                {
                    res += repeatStr;
                }
                num =0;
            }

            else if (ch == ']')
            {
                ++i;
                break;
            }
            else {
                res += ch;
                ++i;
            }
        }
        return res;
    }
}