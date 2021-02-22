// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//We are keeping two stacks, one for pushing numbers and one for pushing the strings.
//Whenever we find opening braces we are pushing digits to integer stack and string to string stack
//whenever we find closing braces we are popping from int stack and processing the string and then pooping the 
//string from string stack and appending it with processed string.

class Solution {
    public String decodeString(String s) {
        if(s==null||s.length()==0){
            return s;
        }
        
        Stack<Integer> stackInt = new Stack<>();
        Stack<String> stackstr = new Stack<>();
        
        String currStr = "";
        int currNo = 0;
        
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                currNo = currNo*10+(ch-'0');
                
            }else if(ch=='['){
                stackInt.push(currNo);
                stackstr.push(currStr);
                
                currNo=0;
                currStr="";
            }else if(ch==']'){
                int no = stackInt.pop();
                String temp = "";
                for(int i=0;i<no;i++){
                    temp+=currStr;
                }
                currStr = stackstr.pop();
                currStr = currStr + temp;
            }else{
                currStr+=ch;
            }
        }
        return currStr;
    }
}
