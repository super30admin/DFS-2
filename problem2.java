// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :no
// Any problem you faced while coding this :failing test case


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        String ans="";
        String temp="";
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                char check=st.pop();
               String k=String.valueOf(check);
                check=st.pop();
                while(check!='['){
                    k=check+k;
                    check=st.pop();
                }
                temp=k+temp;
                k=temp;
                int x= Character.getNumericValue(st.pop());
                for(int j=1;j<x;j++)
                    temp=k+temp;
                ans=ans+temp;
                temp=ans;
            }
            else{
                st.push(s.charAt(i));
                 temp="";
            }
        }
        return ans;
        
    }
}