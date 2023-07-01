public class StringDecodeRecursion {

        //RECURSIVE

        // global i, critical to recursive calls
        int i;

        public String decodeString(String s) {

            // initiate a new current string (empty)
            // currStr = " "
            StringBuilder currStr = new StringBuilder();

            // initiate current number as 0
            int currNum = 0;

            // iterate until last character of encoded string
            while(i < s.length()) {

                // make a current character to check
                char currChar = s.charAt(i);

                // if current character is a digit
                if(Character.isDigit(currChar)) {

                    // update current number (particularly relevant if adjacent characters are numbers)
                    currNum = currNum*10 + currChar - '0';

                    // move i to next character
                    i++;
                }

                else if(currChar == '[') {

                    // move i to next character so that child's recursive call and current parent's recusrive call work on the same character with no gap between two calls
                    i++;

                    // now use decoded child after encoded child's recursive call on s
                    // decoded child is given to parent
                    String child = decodeString(s);

                    // parent's recursion resumes, child is added to parent's stalled current string its(parent's) current number of times
                    for(int k = 0; k < currNum; k++) {

                        currStr.append(child);
                    }
                    // parent's current string is formed, and set current number to zero for conflictless execution of next characters
                    currNum = 0;

                    // parent-child's recursion is done, move global i to next character in encoded string s
                    i++;
                }

                // if current character is a closing bracket
                else if(currChar == ']') {

                    // return decoded child's current string to parent for the parent to resume its earlier recursive call, by converting from string builder to a string
                    return currStr.toString();
                }

                // if current character is a character
                else {

                    // add character to current string
                    currStr.append(currChar);

                    // move i to next character
                    i++;
                }
            }

            // output decoded string by converting current string from string builder to a string
            return currStr.toString();
        }



}

/*
Time Complexity = O(n) = length of decoded string

Space Complexity = O(n) = length of decoded string - recursive stack (nested)
*/

