// Time Complexity : O(n * max(K))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use two stacks one for integer and other for string (StringBuilder).
 * We iterate over string. If we receive a digit we update current number. If we receive a char, we update current StringBuilder
 * If we receive a opening brace, we put both number and string formed so far in recpective stacks and resent them
 * If we receive a closing brace, we first pop the number num from number stack, repreat current string num times
 * Then we make current string =  string_stack.pop() + string form after repeatation
 * At the end once we have iterated over entire input string, we return the result
*/

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> s_char = new Stack<>();
        Stack<Integer> s_int = new Stack<>();
        int num = 0;
        StringBuilder chars = new StringBuilder();
        
        for(int i = 0; i < s.length();i++){
            char curr = s.charAt(i);
            
            if(Character.isDigit(curr)){
                num = num * 10 + curr - '0';
            }else{
                if(curr != '[' && curr != ']'){
                    chars.append(curr);
                }else{
                    if(curr == '['){
                        s_char.push(chars);
                        s_int.push(num);
                        chars = new StringBuilder();
                        num = 0;
                    }else{
                        int count = s_int.pop();
                        StringBuilder sb = new StringBuilder();
                       
                        for(int j = 0; j < count;j++){
                           sb.append(chars);
                        }
                        chars = s_char.pop().append(sb);
                        num = 0;
                    }
                }
            }
        }
        
        return chars.toString();
    }
}