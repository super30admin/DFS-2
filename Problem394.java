//BFS

// Time Complexity : O(o/p length)
// Space Complexity : O(o/p length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> stStack = new Stack<>();
        int currNum =0;
        StringBuilder currSt = new StringBuilder();

        for(int i=0;i<s.length();i++){
                char c= s.charAt(i);
            if(Character.isDigit(c)){
                currNum =currNum*10+ c-'0';
            }
            else if(c=='['){
                intStack.push(currNum);
                stStack.push(currSt.toString());
                currNum=0;
                currSt = new StringBuilder();

            }
            else if(c==']'){
                int curr = intStack.pop();
                 StringBuilder child = new StringBuilder();
                for(int j=0;j<curr;j++){
                    child.append(currSt);
                }
                 StringBuilder parent = new StringBuilder(stStack.pop());
                 currSt=parent.append(child);
            }
            else{
                currSt.append(c);
            }
        }
        return currSt.toString();
    }
}

//DFS
// Time Complexity : O(o/p length)
// Space Complexity : O(o/p length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int i=0;
    public String decodeString(String s) {
        int currNum =0;
        StringBuilder currSt = new StringBuilder();
        while(i<s.length()){
         char c= s.charAt(i);
            if(Character.isDigit(c)){
                currNum =currNum*10+ c-'0';
                i++;
            }
             else if(c=='['){
                 i++;
                 String child = decodeString(s);
                for(int j=0;j<currNum;j++){
                    currSt.append(child);
                }
                 currNum=0;
             }
             else if (c==']'){
                 i++;
                 return currSt.toString();
             }
             else{
                 i++;
                 currSt.append(c);
             }
             
        }
        return currSt.toString();
}
}