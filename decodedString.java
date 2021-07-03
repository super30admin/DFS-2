class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0) return s;
        Stack<String> str=new Stack<>();
        int currNum=0;
        String sr="";
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum=currNum*10+Integer.valueOf(String.valueOf(c));
            }
            else if(c=='[')
            {
                
                str.push(sr);
                str.push(String.valueOf(currNum));
                currNum=0;
                sr="";
            }
            else if(Character.isLetter(c))
            {
                sr=sr+c;
            }
            else 
            {
                int n=Integer.valueOf(str.pop());
                String temp="";
                while(n>0)
                {
                    temp+=sr;
                    n--;
                }
                sr=str.pop();
                sr+=temp;
            }
        }
        
        return sr;
    }
}