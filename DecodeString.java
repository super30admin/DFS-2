import java.util.Stack;

/*
Time Complexity: O(maximum size of the digit we want to append * size of string)
Space Complexity: O(n) size of stack
Run on leetcode: yes
Any difficulties: no

Approach:
1. Considering this string contains both numbers and characters, I will be maintaining two stacks one for number
and other one for StringBuilder
2. I am maintaining one variable to make the digit character in a number appending it with ones place
3. Now when I see square bracket I will push the digit in the countStack and repeat the character inside the stringStack
digit times
 */
public class DecodeString {
    public static String decodeString(String encodedString){
        //"3[a]2[bc]"
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int k=0;
        for(char c : encodedString.toCharArray()){
            if(Character.isDigit(c)){
                k = k*10 + c -'0';
            } else if(c == '['){
                countStack.push(k);
                stringStack.push(result);
                k=0;
                result = new StringBuilder();
            } else if(c == ']'){
                StringBuilder decoded = stringStack.pop();
                int j = countStack.pop();
                while(j>=1){
                    decoded.append(result);
                    j--;
                }
                result = decoded;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println("Decoded String: "+ decodeString("3[a]2[bc]"));
    }
}
