// S30 Big N Problem #65 {Medium}
// 394. Decode String
// Time Complexity : O(l) where l is the string length
// Space Complexity : O(l)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
// DFS solution
class Solution {
    public String decodeString(String s) {
        Stack<Integer> nstack=new Stack<>();
        Stack<String> sstack=new Stack<>();
        char [] array=s.toCharArray();
        
        int currNum=0;
        String currString="";
        for(int i=0;i<array.length;i++){
            if(Character.isDigit(array[i])){
                currNum=currNum*10+ array[i] -'0';
            }else if(array[i]=='['){
                nstack.push(currNum);
                sstack.push(currString);
                currNum=0;
                currString="";
            }else if(array[i]==']'){
                StringBuilder newString=new StringBuilder();
                int num=nstack.pop();
                for(int j=0;j<num;j++){
                    newString.append(currString);
                }
                currString=sstack.pop() +newString;
            }else{
                currString+=array[i];
            }
            
        }
        return currString;
    }
}