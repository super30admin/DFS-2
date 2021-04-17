/**
 *
 *  Time Complexity: O(M*N) Where N is the number of rows and M is number of columns.
 *  Space Complexity: O(M*N) Where N is the number of rows and M is number of columns.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Explanation: We can solve the problem by using a dfs approach. We must have a index pointer which is maintaned globally and we have a helper function which takes in the encoded string and returns a decoded string. In the helper function we iterate over the string. For each character we have 4 basic conditions, we check if its a number and maintain the value for multi-digit number. Seccond we check if the character is an open parentheses, in this case we call the dfs function with the index pointing to first character in the parentheses to get the decoded string within that parenthese. Now we append the returned stirng to the curr string the number of time stored in num variable. Once thats is done we reset the num variable to 0. Third condition is if the character is closing parenthese, in this case we simply inccrement the pointer and return the current string. The forth condition is we find an alphabet that we append to the current string. Finally we return the current string which would be decoded.
 */

class Solution {
    int currIdx;
    public String decodeString(String s) {
        if( s==null || s.length()==0){
            return s;
        }
        currIdx=0;
        return decodeStringHelper(s).toString();
    }
    
    private StringBuilder decodeStringHelper(String s){  
        StringBuilder currStr = new StringBuilder();
        int num=0;
        for(int i=currIdx;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + ch-'0';
            }else if(ch=='['){
                currIdx=i+1;
                StringBuilder str = decodeStringHelper(s);
                i=currIdx;
                StringBuilder updatedStr = new StringBuilder();
                for(int j=0;j<num;j++){
                    updatedStr.append(str.toString());
                }
                currStr.append(updatedStr);
                num=0;
            }else if(ch==']'){
                currIdx = i; 
               return currStr;
            }else{
                currStr.append(ch);
            }
        }
        return currStr;
    }
}
