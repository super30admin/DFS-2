// TC: O(M)
// SC: O(M)
// where M is the number of characters in the output string

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Character> stk = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch==']'){
                StringBuffer es = new StringBuffer();
                while(stk.peek()!='['){
                    es.append(stk.pop());
                }
                stk.pop();
                es.reverse();
                int freq = 0;
                int mul = 1;
                while(!stk.isEmpty() && Character.isDigit(stk.peek())){
                    freq += (stk.pop()-48)*mul;
                    mul *= 10;
                }
                while(freq>0){
                    for(int k=0;k<es.length();k++){
                        stk.push(es.charAt(k));
                    }
                    freq--;
                }
            } else {
                stk.push(ch);
            }
        }
        StringBuffer ans = new StringBuffer();
        while(!stk.isEmpty()){
            ans.append(stk.pop());
        }
        return ans.reverse().toString();
    }
}
