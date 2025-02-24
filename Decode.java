// Time Complexity : O(maxK⋅n), where maxK is the maximum value of k and n is the length of a given string s
// Space Complexity : O(m+n) where m is the number of letters(a-z) and n is the number of digits(0-9) in strings
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Iterate over the stringsand process each character as follows:

Case 1) If the current character is a digit(0-9), append it to the numberk.

Case 2) If the current character is a letter(a-z), append it to thecurrentString.

Case 3) If current character is a opening bracket[, pushkandcurrentStringintocountStackandstringStackrespectively.

Case 4) Closing bracket]: We must begin the decoding process,
 */
class Solution {
    public String decodeString(String s) {
        int k=0;
        Stack<Integer> numStack=new Stack<Integer>();
        Stack<StringBuilder> strStack=new Stack<StringBuilder>();
        StringBuilder curr=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                k=k*10+c-'0';
            }
            else
            if(c=='['){
                numStack.push(k);
                strStack.push(curr);
                k=0;
                curr=new StringBuilder();
            }
            else
            if(c==']'){
                int cnt=numStack.pop();
                StringBuilder str=strStack.pop();
                for(int j=0;j<cnt;j++)
                    str.append(curr);
                curr=str;
            }
            else{
                curr.append(c);
            }
        }

        return curr.toString();
    }
}