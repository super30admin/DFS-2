/*
The time complexity is O(N) and the space complexity is O(N).
Here, we add the characters to the queue until we encounter ']' after which we pop from the queue and process it.

Yes, the code passed all the test cases in leet code.
 */

class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                Character temp = stack.pop(); StringBuilder qs = new StringBuilder();
                while(temp!='['){
                    qs.insert(0,temp);
                    temp = stack.pop();
                }
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num.insert(0,stack.pop());
                }
                int count = Integer.parseInt(num.toString());
                while(count>0){
                    for(int j=0;j<qs.length();j++){
                        stack.push(qs.charAt(j));
                    }
                    count--;
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }

        while(!stack.isEmpty()){
            result.insert(0,stack.pop());
        }

        return new String(result);
    }
}