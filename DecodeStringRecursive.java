// Time Complexity : O(product of nested numbers or max individual number)
// Space Complexity : O(Recursive Stack Space) + O(max nested strings * average string length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Need to revise this logic


// Your code here along with comments explaining your approach

//This is purely DFS problem

//Recursive DFS Solution here
class Solution {

    int i; //Global for a reason
    public String decodeString(String s) {
        //We can combine both the cases in to one as well.
        if(s == null || s.length() == 0) return s;
        int len = s.length();
        // if(len == 1) return s;

        // Stack<Integer> numSt = new Stack<>();
        // Stack<StringBuilder> strSt = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        int currNum = 0;

        for(; i<len; i++){ //In a class, we have done this with while loop
            char c = s.charAt(i);

            //All the strings are of valid type : Given in Problem statement.
            if(c == ']'){
                // int tempNum = numSt.pop();
                // StringBuilder decodeBaby =  new StringBuilder();
                // for(int j =0; j<tempNum; j++){
                //     decodeBaby.append(currStr);
                // }               
                // StringBuilder tempStr = strSt.pop();
                // currStr = tempStr.append(decodeBaby);
                // currNum = 0;
                //i++;
                return currStr.toString();
                
                
            }else if(c == '['){
                // strSt.push(currStr);
                // numSt.push(currNum);
                // currStr = new StringBuilder();
                // currNum = 0;
                i++;
                String baby = decodeString(s); //Recursion ('i' is global variable. Hence, it substring is not required)

                for(int j =0; j<currNum; j++){
                    currStr.append(baby);
                }
                currNum =0;
            }else if(Character.isDigit(c)){
                currNum = currNum*10 + c - '0'; // c- '0' : Gives current number based on ASCII
            }else{ //Alphabet certainly. We have only 4 characters types in my string
                currStr.append(c);
            }

        }
        return currStr.toString();
        
    }
}