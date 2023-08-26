import java.util.*;
class Solution {
    public String decodeString(String input) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int currentCount = 0;
        
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(Character.isDigit(ch)){
                currentCount = currentCount * 10 + ch - '0';
            } else if (ch == '['){
                countStack.push(currentCount);
                stringStack.push(currentString);
                currentCount = 0;
                currentString = "";
            } else if (ch == ']'){
                int repetition = countStack.pop();
                StringBuilder tempString = new StringBuilder();
                for(int j = 0; j < repetition; j++){
                    tempString.append(currentString);
                }
                currentString = stringStack.pop() + tempString;
            } else {
                currentString += ch;
            }
        }
        
        return currentString;
    }
    
    public static void main(String[] args) {
    Solution solution = new Solution();

    String input1 = "3[a]2[bc]";
    String output1 = solution.decodeString(input1);
    System.out.println("Input: " + input1);
    System.out.println("Output: " + output1);  // ans: aaabcbc
    System.out.println();

    String input2 = "3[a2[c]]";
    String output2 = solution.decodeString(input2);
    System.out.println("Input: " + input2);
    System.out.println("Output: " + output2);  // ans: accaccacc
    System.out.println();

    String input3 = "2[abc]3[cd]ef";
    String output3 = solution.decodeString(input3);
    System.out.println("Input: " + input3);
    System.out.println("Output: " + output3);  // ans: abcabccdcdcdef
}

}
