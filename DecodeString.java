// TC: O(n * k) where n is length of s and k is sum of all nums in s
// SC: O(h) where h is height of stack = number of strings we store in stack. Again this is n * k
// class Solution {
//     public String decodeString(String s) {
//         Stack<StringBuilder> strSt = new Stack<>();
//         Stack<Integer> numSt = new Stack<>();

//         int currNum = 0;
//         StringBuilder currStr = new StringBuilder();

//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);

//             if (Character.isDigit(c)) {
//                 currNum = currNum * 10 + (c - '0');
//             }
//             else if (c == '[') {
//                 // push them to stack
//                 strSt.push(currStr);
//                 numSt.push(currNum);

//                 // re-initialize
//                 currStr = new StringBuilder();
//                 currNum = 0;
//             }
//             else if (c == ']') {
//                 StringBuilder parent = strSt.pop();
//                 int count = numSt.pop();

//                 for (int k = 0; k < count; k++) {
//                     parent.append(currStr); // add it to the parent string
//                 }

//                 currStr = parent;
//             }
//             else {
//                 currStr.append(c);
//             }
//         }
//         return currStr.toString();
//     }
// }

// Recursive O(n * k) time, O(n * k) space
class Solution {
    int i = 0;

    public String decodeString(String s) {
        return decode(s);
    }

    public String decode(String s) {

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        while (i < s.length()) {
            char c = s.charAt(i);
            i++;

            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            }
            else if (c == '[') {
                String baby = decodeString(s);

                for (int k = 0; k < currNum; k++) {
                    currStr.append(baby);
                }

                currNum = 0;
            }
            else if (c == ']') {
                return currStr.toString();
            }
            else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}