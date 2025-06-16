//Time Complexity : O(n)
//Space Complexity : O(n)
/* Approach : we are going to keep two stacks i.e, Integer and String stack to track the characters.
We will traverse through the string when we find a Integer we add it to Integer stack else we will add
the characters to string stack at '['. And when we hit ']' we simply pop the Integer stack and print
the current String based on popped Integer. Then we simply pop string stack and append it with current string.
we traverse until the end of string till we get the expected value.
 */

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();        // initiatilize Integer stack to store digits
        Stack<StringBuilder> strStack = new Stack<>();  // initiatilize StringBuilder stack to store characters
        int num = 0;                                    // initialize int variable to get digit from char
        StringBuilder curStr = new StringBuilder();     // initialize string builder
        for(int i=0; i<s.length(); i++){                // traverse through the given string
            char c = s.charAt(i);                       // get the current character
            if(Character.isDigit(c)){                   // validate if current character is a digit
                num = num*10 + c - '0';                 // update the int variable to get digit
            }
            else if(c == '['){                          // validate if it is '['
                numStack.push(num);                     // push digit to Integer stack
                strStack.push(curStr);                  // push charater to String stack
                num = 0;                                // reset int variable for next digit
                curStr = new StringBuilder();           // reset stringbuilder
            }
            else if(c == ']'){                          // validate if it is ']'
                int count = numStack.pop();             // get the digit out of Integer stack
                StringBuilder decodedStr = new StringBuilder(); // initialize temp string variable
                for(int j=0; j<count; j++){             // traverse through the count/digt 
                    decodedStr.append(curStr);          // print characters in current string and store it in temp variable
                }
                curStr = strStack.pop().append(decodedStr); // pop the string stack and append it to temp variable and update it to current string.

            }
            else{
               curStr.append(c);                            // simple append the character to current string.
            }
        }
        return curStr.toString();
    }
}