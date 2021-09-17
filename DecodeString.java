// Time Complexity : O(n) num of char in String
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//1. using stack

class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
       String word = "";
           String decoded = "";
        for(int i = arr.length-1; i >=0 ; i--)
        {  
            if(st.isEmpty())
             word = "";
            if(arr[i] == '[')
            {
                while( !st.isEmpty() )
                {
                    char nextval = st.pop();
                    if(!st.isEmpty() && nextval != ']')
                   word = word +  nextval;
                   else break;
                }
                i--;
       
               int count =    Integer.parseInt( String.valueOf(arr[i]));
         
                
                while(count > 0)
                {
                    decoded = word + decoded ;
                    count--;
                }
                
            }
            else
            st.push(arr[i]);
        }
        
        return decoded;
    }
}