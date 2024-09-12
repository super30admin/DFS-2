// Time Complexity :o(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int cursor=0;
    public String decodeString(String s) {
    StringBuilder result=new StringBuilder();
        int k=0;
        while(cursor<s.length()){
            char t=s.charAt(cursor);
            if(t>='0' && t<='9'){
                cursor++;
                k=k*10+(t -'0');
            }
            else if(t=='[')
            {
                cursor++;
                String res=decodeString(s);
              
                while(k>0){
                    result.append(res);
                    k--;
                }
            }
            else if(t==']'){
                cursor++;
               return result.toString();
            }
            else{
               cursor++;
                result.append(t);
            }
        }
        System.out.println(result.toString());
        return result.toString();
    }
}