// Time Complexity : O(n+no of popNums)
// Space Complexity : O(n) for 2 stacks together.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public String decodeString(String s) {
        if (s==null ||s.length()==0){
            return "";
        }
        Stack<Integer> numStack=new Stack<>();
        Stack<String> strStack=new Stack<>();
        
        int curNum=0;
        String curStr="";
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                curNum= curNum*10+(ch-'0');
            }
            else if(ch=='['){
                numStack.push(curNum);
                strStack.push(curStr);
                
                curNum=0;
                curStr="";
            }
            else if(ch==']'){
                int popNum=numStack.pop();
                String temp="";
                for(int j=0;j<popNum;j++){
                    temp+=curStr;
                }
                curStr=strStack.pop()+temp;
            }
            else{
                curStr+=ch;
            }
        }
        return curStr;
    }
}