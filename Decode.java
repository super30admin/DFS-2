//Time COmplexity: O(n)
//Space COmplexity: O(n) for stacks
//Leetcode: Yes


class Solution {
    public String decodeString(String s) {
        Stack<String> result = new Stack(); // to store the characters
        Stack<Integer> countStack = new Stack(); //to check the result stack till what point the stack has to be popped
        
        int index = 0;
        String res = "";
        
        while(index < s.length()){
            //we have 4 cases 
            //find and form the number
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = count * 10 + (s.charAt(index)-'0');
                    index++;
                }
                countStack.push(count);
            }
            
            //If you encounter a [ put the next in the result stack
            
            else if(s.charAt(index)=='['){
                result.push(res);
                res = "";
                index++;
            }
            else if(s.charAt(index)==']'){
                StringBuilder temp = new StringBuilder(result.pop());
                int number = countStack.pop();
                //iterate till number and append to the temp
                for(int i =0;i<number;i++){
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            }
            else {
                res+= s.charAt(index);
                index++;
            }
            
        }
        return res;
        
    }
}
