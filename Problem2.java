// Time Complexity : O(N), N is size of string s + sum of nums in s
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {

        Deque<Integer> intStack = new LinkedList<>();
        Deque<String> stringStack = new LinkedList<>();
        String curr = "";
        String temp = "";
        int num = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){ //convert to num
                num = num*10 + ch-'0';
            }else if(ch == '['){ //add to stack & reset
                stringStack.push(curr);
                intStack.push(num);
                num = 0;
                curr = "";
            }else if(ch == ']'){ //pop & create string in curr
                int N = intStack.pop();
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<N;i++){ //create temp string
                    sb.append(curr);
                }
                temp = sb.toString();
                curr = stringStack.pop();
                curr = curr+temp;
            }else{ //append encoded string
                StringBuilder sb = new StringBuilder(curr);
                sb.append(String.valueOf(ch));
                curr = sb.toString();
            }
        }

        return curr;
    }
}