//Time complexity :O(m*n)
//Space complexity:O(m*n)
// using switch case 
class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder currString = new StringBuilder();
        int num = 0;
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //4 options
            switch(c) {
                case '[' :
                   numStack.push(num);
                   strStack.push(currString);
                   currString = new StringBuilder();
                   num = 0;
                   break;
                case ']' :
                   int times = numStack.pop();
                   StringBuilder newString = new StringBuilder();
                   for(int j = 0; j < times; j++) {
                       newString.append(currString);
                   }
                   currString = strStack.pop().append(newString);
                   break;
                default:
                   if(Character.isDigit(c)) {
                       num = num * 10 + c - '0';
                       break;
                   }
                   currString.append(c);
            }
        }
        return currString.toString();
    }
}