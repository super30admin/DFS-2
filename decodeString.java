// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
         
        Stack<Integer> nums = new Stack<Integer>();
        Stack<StringBuilder> strings = new Stack<StringBuilder>();
        int num = 0;
        StringBuilder currString = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            //ascii value
            if (Character.isDigit(ch)) {
                num = 10 * num + ch - '0';
            }
            else if(ch =='[') {                
                nums.add(num);
                num = 0;
                strings.add(currString);                
                currString = new StringBuilder();
            }
            else if (ch == ']') {
                int times = nums.pop();
                //new string
                StringBuilder newString = new StringBuilder();
                for(int j = 0;j<times;j++) {
                    newString.append(currString);
                }
                currString = strings.pop().append(newString);                
            }
            else {
                currString.append(ch);
            }
        }

        return currString.toString();
    }
}