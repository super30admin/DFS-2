class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums=new Stack<>();
        Stack<String> strings =new Stack<>();
        int num=0;
        String str="";
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                num=num*10+c-'0';
            }
            else if(c=='[')
            {
                nums.push(num);
                strings.push(str);
                num=0;
                str="";
            }
            else if(c==']')
            {
                StringBuilder newStr=new StringBuilder();
                int temp=nums.pop();
                for(int j=0;j<temp;j++)
                {
                    newStr.append(str);
                }
                str=strings.pop()+newStr.toString();
            }
            else
            {
                str=str+c;
            }
        }
        return str;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)