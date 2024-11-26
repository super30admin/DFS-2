// Approach : Using Two stack
// Time : O(N) and k times = O(NK) # worst case
// Space: O(M+N)
class Solution {
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        // edge case
        if(s == null || s.length() == 0) return currStr.toString(); // empty string
        int currNum = 0;
        Stack<Integer> numStk = new Stack<>();
        Stack<StringBuilder> strStk = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            // case 1 
            if(Character.isDigit(c)){
                currNum = currNum*10 + c - '0';
            } else if(c == '['){
                // case 2
                numStk.push(currNum);
                strStk.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();

            } else if(c==']'){
                // case 3 - first pop the numStk and multiple with currString and this form a new string.
                // pop str from strStk and combine it with newString
                int times = numStk.pop();
                StringBuilder newStr=  new StringBuilder();
                for(int k =0;k<times;k++){ // k times
                    newStr.append(currStr);
                }
                currStr=strStk.pop().append(newStr);
            } else {
                // case 4
                currStr.append(c);
            }
        }

        return currStr.toString();
// Approach : Using Recursion
// Time : O(nk)
// Space : O(n)
class Solution {
    int i=0;
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        if (s == null || s.length()==0) return currStr.toString();
        int currNum = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            // case 1 - Digit at 
            if(Character.isDigit(ch)){
                currNum = currNum*10 + ch - '0';
                i++;
            } else if(ch == '['){
                i++;
                String innerStr = decodeString(s);
                for(int k = 0;k<currNum;k++){
                    currStr.append(innerStr);
                }
                currNum = 0;
            } else if (ch == ']'){
                // return the inner processed string
                i++;
                return currStr.toString();
            } else{
                currStr.append(ch);
                i++;
            } 
        }
        return currStr.toString();
    }
}
    }
}

