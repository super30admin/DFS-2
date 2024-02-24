//TimeComplexity : O(m*n)
//SpaceComplexity: O(m*n)

class Solution {
    public String decodeString(String s) {
        // DFS Iterative
        Stack<StringBuilder> stkstring = new Stack<>();
        Stack<Integer> stkNumber = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int number =0;
        for(int i =0; i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = number*10 + c-'0';
                
            } else if(c == '[') {
                stkNumber.push(number);
                stkstring.push(currStr);
                currStr = new StringBuilder();
                number =0;
            } else if(c == ']') {
                 StringBuilder parent = new StringBuilder();
                 int n = stkNumber.pop();
                 for(int k =0; k<n;k++) {
                     parent.append(currStr);
                 }
                 StringBuilder p = new StringBuilder();
                 p = stkstring.pop();
                 p.append(parent);
                 currStr = p;
            } else {
                 currStr.append(c);
            }
        }
        return currStr.toString();
    }
}