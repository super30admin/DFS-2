// Time Complexity : O(N)
// Space Complexity : O(N) Stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Loop through the string. Have two stacks, one for character stack, other for number stack.
Whenever char is found append to currStr and when digit is found form the number
when open bracket is found push currStr to charstack and digit to num stack
when ever closed bracket is found, pop charstack and numstack, iterate popped charStack
append currStr to it and assign total value to currStr
*/
class DecodeString {
    public String decodeString(String s) {
        if(s.length()==0 || s==null) return "";

        Stack<StringBuilder> strStack= new Stack<>();
        Stack<Integer> numStack= new Stack<>();
        int num=0;
        StringBuilder currStr=new StringBuilder();

        for(int i=0;i< s.toCharArray().length;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                num= num*10+ ch-'0';
            }else if(ch=='['){
                strStack.push(currStr);
                numStack.push(num);
                //reset
                currStr=new StringBuilder();
                num=0;
            }else if(ch==']'){
                int freq=numStack.pop();
                StringBuilder addition= strStack.pop();
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<freq;j++){
                    sb.append(currStr);
                }
                currStr=addition.append(sb);
            }else{
                currStr=currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}