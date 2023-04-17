// ******************** DFS iterative approach **********
// Time Complexity:  O(n)
// Space Complexity: O(h)
// where n is length of string
// and h is number of iterations

class Solution {
    public String decodeString(String s) {

        Stack<StringBuilder> sbStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        StringBuilder curStr = new StringBuilder();
        int num = 0;
        
        for(int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);                                     // getting character one by one

            if(Character.isDigit(c)) {                                // 1) if it is a digit
                num = num*10 + (c - '0');                             // update num
            }
            else if(c == '[') {                                       // 2) if it is '['
                sbStack.push(curStr);                                 // push curStr, num in stack and reset them
                numStack.push(num);                                   
                curStr = new StringBuilder();
                num = 0;
            }
            else if(c == ']') {                                       // 3) if it is ']'
                int count = numStack.pop();                           // get count of child and repeat it as per its num and append it in parent 
                StringBuilder parentStr = sbStack.pop();
                while(count-- > 0) {
                    parentStr.append(curStr);
                }
                curStr = parentStr;
            }
            else {                                                    // 4) if it is a character
                curStr = curStr.append(c);                            // just append it in curStr
            }
        }

        return curStr.toString();

    }
}



// ******************** DFS recursive approach **********
// Time Complexity:  O(n)
// Space Complexity: O(h)
// where n is length of string
// and h is height/depth of recursion

class Solution {

    int i = 0;

    public String decodeString(String s) {

        StringBuilder curStr = new StringBuilder();
        int num = 0;
        
        while(i < s.length()) {
            
            char c = s.charAt(i);                                     // getting character one by one

            if(Character.isDigit(c)) {                                // 1) if it is a digit
                num = num*10 + (c - '0');                             // update num
                i++;
            }
            else if(c == '[') {                                       // 2) if it is '['
                i++;    
                String child = decodeString(s);                       // go in next level recursion and get decoded string from it returned
                while(num > 0) {
                    curStr.append(child);                             // append child's decoded string num times to parent
                    num--;
                }
            }
            else if(c == ']') {                                       // 3) if it is ']'
                i++; 
                return curStr.toString();                             // return curStr
            }
            else {                                                    // 4) if it is a character
                curStr = curStr.append(c);                            // just append it in curStr
                i++;
            }
        }

        return curStr.toString();

    }
}
