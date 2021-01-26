// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String decodeString(String s) {
        StringBuilder curStr=new StringBuilder();
        int currCount=0;
        Stack<StringBuilder> strStack=new Stack<StringBuilder>();
        Stack<Integer> numStack=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                currCount=10*currCount+(s.charAt(i)-'0');
            }else if(Character.isLetter(s.charAt(i))){
                //System.out.println(s.charAt(i));
                curStr.append(s.charAt(i));
            }else if(s.charAt(i)=='['){
                //System.out.println(currCount);
                numStack.push(currCount);
                //System.out.println(curStr);
                strStack.push(curStr);
                currCount=0;
                curStr=new StringBuilder();
            }else if(s.charAt(i)==']'){
                int num=numStack.pop();
                StringBuilder str=new StringBuilder();
                for(int k=0;k<num;k++){
                    str.append(curStr);
                }
                curStr=strStack.pop().append(str);
                
            }
        }
        // System.out.println(currCount);
        // System.out.println(curStr);
        return curStr.toString();
    }
}

//the dfs solution
class Solution {
    private int i=0;
    public String decodeString(String s) {
        StringBuilder curStr=new StringBuilder();
        int currCount=0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                currCount=10*currCount+(s.charAt(i)-'0');
                i=i+1;
            }else if(Character.isLetter(s.charAt(i))){
                curStr.append(s.charAt(i));
                i=i+1;
            }else if(s.charAt(i)=='['){
                i=i+1;
                String st=decodeString(s);
                StringBuilder str=new StringBuilder();
                for(int i=0;i<currCount;i++){
                    str.append(st);
                }
                curStr.append(str);
                currCount=0;
            }else if(s.charAt(i)==']'){
              i=i+1;
              return curStr.toString();
            }
        }
       return curStr.toString();
    }
}