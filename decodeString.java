//time O(N) where N is the product of all the integers in the string and length of the string
//space O(h) stack space

class Solution {
    public String decodeString(String s) {
        Stack<Integer> stackIn = new Stack<>();
        Stack<StringBuilder> stackStr = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);            
            //int
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            }
            
            // [
            else if(c == '[') {
                stackIn.push(currNum);
                stackStr.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            }
            
            // ]
            else if(c == ']') {
                int num = stackIn.pop();
                StringBuilder ssb = new StringBuilder();
                for(int j = 0; j < num; j++) {
                    ssb.append(currStr);
                }
                StringBuilder parent = stackStr.pop();
                currStr = parent.append(ssb);
            } 
            
            else if(Character.isLetter(c)) {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
