// Runtime complexity - O(nk^countk) where n is the length of the encoded string and k is the maximum number of value to decode as it has forloop and countk is the number of time there is a number to run the loop on.

// space complexity - O(nk^countk)

class Solution {
    public String decodeString(String s) {
        Stack<Character> s1=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==']')
            {
                String decode="";
                String ans="";
                while(s1.peek()!='[')
                    decode = Character.toString(s1.pop())+decode;
                s1.pop(); // removes the open bracket;
                int base = 1;
                int k = 0;
                while (!s1.isEmpty() && Character.isDigit(s1.peek())) {
                    k = k + (s1.pop() - '0') * base;
                    base *= 10;
                }
                for(int j=0;j<k;j++)
                    ans=ans+decode;
                System.out.println("ans:"+ans);
                for(int m=0;m<ans.length();m++)
                    s1.push(ans.charAt(m));
            }
            else
            {
                s1.push(s.charAt(i));
            }
                
        }
        // get the result from stack
        char[] result = new char[s1.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = s1.pop();
        }
        return new String(result);
    
    }
}
