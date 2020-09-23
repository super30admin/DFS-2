// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        
        if(s==null || s.length()==0){
            return "";
        }
        
        Stack<Integer> numstack = new Stack<>();
        Stack<String> strstack = new Stack<>();
        
        int currnum=0;
        String currstring="";
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currnum=currnum*10 + (ch-'0');
            }else if(ch  == '['){
                numstack.add(currnum);
                strstack.add(currstring);
                currnum=0;
                currstring="";
            }else if(ch == ']'){
                int poppedInt = numstack.pop();
                String temp="";
                for(int x=0;x<poppedInt;x++){
                    temp+=currstring;
                }
                currstring=strstack.pop();
                currstring+=temp;
            }else{
                currstring+=ch;
            }
        }
        return currstring;
    }
}