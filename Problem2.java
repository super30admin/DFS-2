// Time Complexity - O(n) where n is the length of the String
// Space Complexity - O(n) where n is the length of the String. n is the total space used by both the stacks


class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();    // To process characters in the string
        Stack<String> strStack = new Stack<>();   // To process digit in the string
        int currNum = 0;
        String currStr = "";
        for(int k =0;k < s.length(); k++){      // Iterate over the string to process each character in the string
            char c = s.charAt(k);
            if(Character.isDigit(c)){
                currNum = currNum * 10 +c -'0';     // This will convert the char number to integer and also append to the currNum if it is a multi digit number
            }   
            else if(c == '['){              // If it is opening bracket, it means push the number in currNum and string currStr that came before the bracket to the stack to process on closing bracket
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;    // and reinitialize the currNum and currStr to take new values inside the bracket
                currStr = "";
            }
            else if(c == ']'){      // on closing bracket pop the number num from stack and add the currStr num times and add the top of strStack with it.
                int num = numStack.pop();
                StringBuilder str = new StringBuilder();
                for(int i=0; i< num;i++){
                    str.append(currStr);   
                }
                currStr = strStack.pop() + str;
                
            }
            else{
                currStr += c;   // else if it is character add it to the currStr
            }
        }
        return currStr; // return the currStr which will have the resultant string in the end
    }
}
