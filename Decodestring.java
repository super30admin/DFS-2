// Time Complexity: O(nL)
// Space Complexity: O(n+L)
//use numstack, stringbuilder stack, currNum to keep track
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack= new Stack<>();

        int currNum = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }
            else if(c == '['){
                strStack.push(sb);
                numStack.push(currNum);
                currNum = 0;
                sb = new StringBuilder();

            }else if(c == ']'){
                int num = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for(int k =0; k<num; k++){
                    temp.append(sb);
                }

                sb = strStack.pop();
                sb.append(temp);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}