// Time Complexity : O(n) where n is length of input string
// Space Complexity : O(n) recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Parse the string character by character.
//   - If a digit is encountered, build the number (for k repetitions).
//   - If a '[' is encountered, recursively decode the substring inside the brackets.
//   - If a ']' is encountered, return the decoded substring so far.
//   - Otherwise, keep appending normal characters to the current string.

public class DecodeString {
    // public String decodeString(String s) {
    //     Stack<Integer> numSt = new Stack<>();
    //     Stack<StringBuilder> strSt = new Stack<>();

    //     int currNo = 0;
    //     StringBuilder currStr = new StringBuilder();

    //     for(int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if(Character.isDigit(c)) {
    //             currNo = currNo * 10 + c - '0';
    //         } else if(c == '[') {
    //             numSt.push(currNo);
    //             strSt.push(currStr);
    //             currNo = 0;
    //             currStr = new StringBuilder();
    //         } else if(c == ']') {
    //             int count = numSt.pop();
    //             StringBuilder parent = strSt.pop();
    //             for(int j = 0; j < count; j++) {
    //                 parent.append(currStr);
    //             }
    //             currStr = parent;
    //         } else {
    //             currStr.append(c);
    //         }
    //     }

    //     return currStr.toString();
    // }


    int i = 0;  //index
    public String decodeString(String s) {
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        while(i < s.length()) {
            char c = s.charAt(i);
            i++;

            if(Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            } else if(c == '[') {
                String baby = decodeString(s);
                for(int k =0; k < currNum; k++) {
                    currStr.append(baby);
                }
                currNum = 0; //reset number
            } else if(c == ']') {
                return currStr.toString();
            } else {
                currStr.append(c);
            }
        }

        return currStr.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();

        String s1 = "3[a]2[bc]";
        System.out.println("Decoded string of '" + s1 + "': " + solution.decodeString(s1));

    }
}
