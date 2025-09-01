/* 
Time Complexity: O(n × k) 
   - n = length of the input string 
   - k = maximum repeat count 
   - because repeating substrings can blow up the work proportional to the size of the output

Space Complexity: O(n × k) 
   - stacks + final decoded string (worst case proportional to output size)
   
Did this code successfully run on Leetcode: Yes

// Approach:
// 1. Use two stacks — one for repeat counts (numSt) and one for partial strings (strSt).
// 2. Traverse the string:
//    - If digit: build current number (handles multi-digit).
//    - If '[': push current string and number, then reset for a new segment.
//    - If ']': pop number and parent string, repeat current string 'count' times and append to parent.
//    - If letter: just append to current string.
// 3. Continue until the end. The final string in currStr is the decoded result.*/


import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            }else if(c == '['){

                strSt.push(currStr);
                numSt.push(currNum);

                currNum = 0;
                currStr = new StringBuilder();

            }else if(c == ']'){

                int cnt = numSt.pop();
                StringBuilder parent = strSt.pop();

                for(int k=0; k<cnt; k++){
                    parent.append(currStr);
                }
            
                currStr = parent;

            }else{
                currStr.append(c);
            }
        }

        return currStr.toString();
    }
}
