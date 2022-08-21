// Time Complexity : O(maxK * n) where maxK is the maximum value any num encountered
// Space Complexity : O(m + n) where m is the number of letters and n is the number of digits
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Iterative Approach
 * The idea is to keep the parent and decode the inner subproblem first in a dfs manner
 * 
 * When we encounter '[', enqueue curr String and currNum into respective stack, Also set the currString to "" and num to 0.
 * When we encounter ']', we decode the sreing by popping the num from numStack 
 * and later combine with parent popped from stringStack
 * When we get a character, we add to the currString.
 */

class Solution {
    public String decodeString(String s) {
        int i=0;
        
        // NumStack for storing the parent num multiplier
        Stack<Integer> numStack = new Stack<>();
        // StringStack to store parent String
        Stack<StringBuilder> strStack = new Stack<>();
        
        int num = 0;
        
        // currString to store currString
        StringBuilder curr = new StringBuilder();
        
        while (i < s.length()) {
            char ch = s.charAt(i);
                
            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
                
                i++;
            } else if (ch == '[') {
                numStack.add(num);
                strStack.push(curr);
                num = 0;
                curr = new StringBuilder();
                
                i++;
            } else if (ch == ']') {
                int currNum = numStack.pop();
                StringBuilder temp = new StringBuilder();
                
                for (int j=0;j<currNum;j++) {
                    temp.append(curr);
                }
                
                curr = strStack.pop().append(temp);
                
                i++;
            } else {
                curr.append(ch);
                
                i++;
            }
        }
        
        return curr.toString();
    }
}



/**
* Recursive approach
*/

class Solution {
    public String decodeString(String s) { 
        Queue<Character> q = new LinkedList();
        for(char ch: s.toCharArray()) {
            q.add(ch);
        }
        return helper(q);
    }
    
    private String helper(Queue<Character> q) {
        
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while (!q.isEmpty()) {
            char ch = q.poll();
            
            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
                
            } else if (ch == '[') {
                String decoded = helper(q);
                
                for (int i=0;i<num;i++) {
                    sb.append(decoded);
                }
                
                num = 0;
                
            } else if (ch == ']') {
                break;
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
     }
}
