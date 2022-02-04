import java.util.Stack;

// Time Complexity : O(length of decipher string)
// Space Complexity : O(m + n) m = number of letters, n-number of digits
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DecodeString_Iterative {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        decodeString(s);
    }

    public static String decodeString(String s) {
        int num = 0;
        StringBuilder curr = new StringBuilder();
        Stack<StringBuilder> parentStk = new Stack<>();
        Stack<Integer> numStk = new Stack<>();

        for(int i=0; i<s.length(); i++){  // T.C - O(decoded string)  S.C - O(m+n)
            char c = s.charAt(i);

            // c - num
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            } else if (c == '['){  // c - '['
                numStk.push(num);
                parentStk.push(curr);
                num = 0;
                curr = new StringBuilder();
            } else if (c == ']'){  // c - ']'
                int k = numStk.pop();
                StringBuilder child = new StringBuilder();
                for(int j=0 ; j<k; j++){
                    child = child.append(curr);
                }
                StringBuilder temp = parentStk.pop();
                curr = temp.append(child);
            } else {  // c - character
                curr.append(c);
            }
        }
        return curr.toString();
    }
}

