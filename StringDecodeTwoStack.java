import java.util.Stack;

public class StringDecodeTwoStack {

        // TWO STACK APPROACH

        public String decodeString(String s) {

            // create number stack
            Stack<Integer> numStk = new Stack<>();

            // create string stack
            Stack<StringBuilder> strStk = new Stack<>();

            // initiate current number as 0
            int currNum = 0;

            // initiate a new current string (empty)
            // currStr = " "
            StringBuilder currStr = new StringBuilder();

            // iterate over each character of encoded string
            for(int i = 0; i < s.length(); i++) {

                // make a current character to check
                char currChar = s.charAt(i);

                // if current character is a digit
                if(Character.isDigit(currChar)) {

                    // update current number (particularly relevant if adjacent characters are numbers)
                    currNum = currNum*10 + currChar - '0';
                }

                // if current character is an opening bracket
                else if(currChar == '[') {

                    // make way for a child by pushing current number and string into respective stacks
                    numStk.push(currNum);
                    strStk.push(currStr);

                    // reset current number and string for execution of child
                    currStr = new StringBuilder();
                    currNum = 0;
                }

                // if current character is a closing bracket
                else if(currChar == ']') {

                    // get count of repetition of child by popping from number stack
                    int count = numStk.pop();

                    // make a new child stringbuilder
                    // child = " "
                    StringBuilder child = new StringBuilder();

                    for(int k = 0; k < count; k++) {

                        // make child by repeating current string until count is reached
                        child.append(currStr);
                    }

                    //  make a string builder from parent string popped from string stack
                    StringBuilder parent = strStk.pop();

                    // update current string by combining parent and child string builders
                    currStr = parent.append(child);

                }

                // if current character is a character
                else {

                    // add character to current string
                    currStr.append(currChar);
                }
            }

            // output decoded string by converting current string from string builder to a string
            return currStr.toString();
        }

}

/*
Time Complexity = O(n) = length of decoded string

Two distinctive stacks to keep consistent data types in each stack

String stack will contain O(n)
or number at maximum depth* all numbers in last but current string

Space Complexity = O(n) = length of decoded string
*/

