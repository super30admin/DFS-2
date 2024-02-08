// Time Complexity :o(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: Solve it using two stacks.

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack=new Stack<>();
        Stack<StringBuilder> strStack=new Stack<>();

        StringBuilder currentStr= new StringBuilder();
        int i=0;
        int num=0;
        while(i<s.length()){
            char ch= s.charAt(i);
            if(Character.isDigit(ch)){
                num= num*10+(ch-'0');
            }
            else if(ch=='['){
                numStack.push(num);
                strStack.push(currentStr);
                num=0;
                currentStr=new StringBuilder();
            }
            else if(ch==']'){
                StringBuilder decodedStr= strStack.pop();
                int k=numStack.pop();
                for(int j=0; j<k;j++){
                    decodedStr.append(currentStr);
                }
                currentStr = decodedStr;
            }else{
                currentStr.append(ch);
            }
            i++;    
        }
    return currentStr.toString();
    }
}
