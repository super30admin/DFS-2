/* Time complexity: O(m*n)
space complexity: O(n)
*/

class Solution{
    public String decodeString(String S){
        StringBuilder currStr = new StringBuilder();
        //edge
        if(S == null || S.length == 0) return currStr.toString();
        int num = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        for(int i=0; i<S.length; i++){
            Char c = S.charAt(i);
            if(Character.isDigit(c)){
                num = 10*num+c-'0';
            }else if(c == '['){
                numStack.push(num);
                strStack.push(currStr);
                num = 0; currStr = new StringBuilder();
            }else if(c == ']'){
                int times = new Stack.pop();
                StringBuilder newString = new StringBuilder();
                for(int k=0; k<times; k++){
                    newString.append(currStr);
                }
                currStr = strStack.pop().append(newString);
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}