// Time Complexity : O(output)
// Space Complexity : O(output)dfs - how many nesting loops are there
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//BFS
//Time = O(output) - length of output
class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0){
            return "";//returning empty string 
        }
        //best datastructure to use to mutate the string is string builder
        Stack<StringBuilder> st = new Stack<>();
        Stack<Integer> numst = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                // we do this because it can be a two digit number
                num = num * 10 + (c - '0');
                
            }else if(c=='['){
                //adding to stacks
                st.push(currStr);
                numst.push(num);
                
                //resetting the values
                currStr = new StringBuilder();
                num = 0;
                
            }else if(c==']'){
                //decoding
                int count = numst.pop();
                
                //we need new Stringbuilder to store the decoded string
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<count; j++){
                    sb.append(currStr);//append as many times as the count
                }
                
                //we need a new StringBuilder for parent
                StringBuilder parent = st.pop();
                currStr = parent.append(sb);
                
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}

//DFS
