//Problem : 67 - Decode String
//Time Complexity : O(n*Max(k)), n is string length and K is the number associated in decoding the string
// Space Complexity : O(n), n is length of string which is combination of number of digits & number of characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
  First we have to decode the child, then the parent. Follow below steps
  Initialise two stacks, one for storing the parent string called strSTack. Otherone for storing numbers called numStack. Make sure datatype of String stack is StringBuilder because it is efficient than String. Initialse two variables one num of int type. Second currString, its datatype should be StringBuilder.Now implement following 4 cases.
  
  1) If character is number, then just store it in num variable
  2) If Character is starting square bracket "[", then just insert num variable data in numStack and currString data in strStack. After inserting them into their respective stack, just reset the num to 0 and currString to new StringBuilder. 
  3) If Character is closing square bracket "]", then pop the peek element from the num stack call it nTimes. Initialise a new StringBuilder object call it sb. Append the currentString nTimes to the sb which is StringBuilder object. After that pop the peek element from strStack and append sb to the popped string and then set this to the currentString.  
  4) If Character is alphabet, then append it to currString variable. 
  

*/
import java.util.*;
class Solution67 {
    public String decodeString(String s) {
        
        if(s==null || s.length()==0) return "";
        
        //TC: O(n*Max(k)), n is string length
        //SC: O(n), n is length of string which is combination of number of digits & number of characters
        
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';//will convert char to integer
            }else if(ch=='['){
                strStack.push(currStr);
                numStack.push(num);
                
                //reset curr string and number
                currStr = new StringBuilder();
                num     = 0;
                
            }else if(ch==']'){//closing brackets, decode the string
                
                //pop from num stack so that element can be appended n times
                int nTimes = numStack.pop();
                
                StringBuilder sb = new StringBuilder();
                for(int k=0;k<nTimes;k++){ //TC: O(K)
                    sb.append(currStr);
                }
                
                 //combine it with parent
                 currStr = strStack.pop().append(sb);
                
            }else{//ch is alphabet
                currStr.append(ch);//keep appending the character
            }
            
        }
       
        return currStr.toString();
    }
}