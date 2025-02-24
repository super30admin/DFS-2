// TimeComplexity: O(max(k, n)) where k product of nestings and n is the length of the string.
// Space Complexity: O(max(k, n)) where k product of nestings and n is the length of the string.

// Approach:
// 1. We use two stacks, one for numbers and one for strings.
// 2. We iterate through the string and check if the character is a digit, we keep on multiplying the number by 10 and add the digit to it.
// 3. If we encounter a '[', we push the number to the number stack and the current string to the string stack.
// 4. If we encounter a ']', we pop the number from the number stack and the string from the string stack.
// 5. We create a new string and append the current string to it for the number of times the number is present.
// 6. We append this new string to the parent string and continue the process.

import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        int num = 0;
        StringBuilder currSt = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
                continue;
            }

            if(ch == '['){
                numStack.push(num);
                strStack.push(currSt);
                currSt = new StringBuilder();
                num = 0;
            }else if(ch == ']'){
                int times = numStack.pop();
                StringBuilder baby = new StringBuilder();
                StringBuilder parent = strStack.pop();
                for(int k = 0; k < times; k++){
                    baby.append(currSt);
                }
                parent.append(baby);
                currSt = parent;
            }else{
                currSt.append(ch);
            }
        }
        return currSt.toString();
    }
}