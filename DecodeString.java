//Time Complexity: O(strLength * MaxNum_in_str)..where strLength=s.length()
//Space Complexity: O(strLength * MaxNum_in_str)
// 394. Decode String
class Solution {
    public String decodeString(String s) {
        Stack<Integer> num= new Stack<>();
         Stack<StringBuilder> stack= new Stack<>();
        int n=s.length();
        if(n==1)
            return s;
        
        StringBuilder res=new StringBuilder();
        StringBuilder str=new StringBuilder();        
        int freq=0;
        char ch;
        for(int i=0;i<n;i++)
        {
            ch=s.charAt(i);
                if (Character.isDigit(ch))
                {

                    freq=freq*10 + Character.getNumericValue(ch);

                }
                else if(ch=='[')
                {
                    num.add(freq);
                    freq=0;
                    stack.add(str);
                    str=new StringBuilder();
                }
                else if(ch==']')
                {
                    int repeat=num.pop();
                    
                    StringBuilder newStr=new StringBuilder();
                    for(int k=0;k<repeat;k++)
                    {
                        newStr.append(str);
                    }
                   
                    StringBuilder parent = stack.pop();
                    str = parent.append(newStr);
                    
                }
                else
                {
                    str.append(ch);
                }
                
                
        }
        
        
        return str.toString();
            
        
    }
}