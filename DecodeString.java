// Time Complexity : O(K * n) where k is the highest number of repetations and n is length of string
// Space Complexity : O(m+n) no of letters + no of digits
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

//use two stack for storing the curr string and the number of repetations 
//parse the string and put the curr string in stack when processng child
//when brakcet closed pop the string and append.
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int cuNum = 0;
        StringBuilder curStr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                cuNum = cuNum * 10 + c - '0';
            } else if (c == '[') {
                strStack.push(curStr);
                numStack.push(cuNum);
                cuNum = 0;
                curStr = new StringBuilder();
            } else if (c == ']') {
                int cnt = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int k = 0; k < cnt; k++) {
                    temp.append(curStr);
                }
                curStr = strStack.pop();
                curStr.append(temp);
            } else {
                curStr.append(c);
            }
        }

        return curStr.toString();
    }

    // Driver method
    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        
        // Example usage
        String encodedString = "3[a2[bc]]";
        String decodedString = solution.decodeString(encodedString);
        
        System.out.println("Encoded String: " + encodedString);
        System.out.println("Decoded String: " + decodedString);
    }
}

