// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : StringBuilder in line 37

// 394. Decode String


class Solution {
    public String decodeString(String s) {
        int n = s.length();
        int count = 0;

        StringBuilder curr = new StringBuilder();

        Stack<Integer> numStack = new Stack<>();
        Stack<String> wordStack = new Stack<>();

        for(int i = 0; i < n; i++){
            char a = s.charAt(i);
            if(Character.isDigit(a)){
                count = count * 10 + (a - '0');
            }
            else if(a == '['){
                numStack.push(count);
                wordStack.push(curr.toString());
                count = 0;
                curr = new StringBuilder();
            }
            else if(a == ']'){
                StringBuilder sb = new StringBuilder();
                int c = numStack.pop();
                for(int j = 0; j < c; j++){
                    sb = sb.append(curr);
                }
                
                curr = new StringBuilder(wordStack.pop() + sb.toString());
            }
            else{
                curr.append(a);
            }
        }
        return curr.toString();
    }
}
