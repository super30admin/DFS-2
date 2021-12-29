/* Time Complexity : O(K*N) where K is the number of times the character repeated and N is the number of characters.
 Space Complexity :O(K*N)
 Did this code successfully run on Leetcode : yes
 Any problem you faced while coding this : no
 */
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        for(int i = 0; i<s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c -'0';
            }
             else if(c == '['){
                strStack.push(result);
                numStack.push(num);
                num = 0;
                result = new StringBuilder();
            }
            else if(c == ']'){
                int times = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for(int j = 0 ; j<times ;j++){
                    temp.append(result);
                }
                result = strStack.pop().append(temp);   
            }
            else{
                result.append(c);
            }
        }
       return result.toString(); 
    }
}
