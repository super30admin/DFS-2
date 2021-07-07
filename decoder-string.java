// Time Complexity : length of decoded string
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


//-Create 2 stack one to store numbers and another for alphabte
//-Miantain currNum and currString, where number to repeate  n-time the same string and currString for generated string
//-Iterate through String and convert char num to int ans push into stack and append alphabate to StringBuilder.
//-on opening bracket push the currSum and currString to stack and initialize to  0 and blank again.
//-on closing blacket pop the number append the currString to newString by n-times and append to currString
//--return currString


// Your code here along with comments explaining your approach

import java.util.*;
class Main{
  public static void main(String []args){
    String s="3[a]2[bc]";
    System.out.println(decodeString(s));
  }
  public static String decodeString(String s){
    if(s==null || s.length()==0){
            return s;
        }
        Stack <Integer> numStack=new Stack<>();
        Stack <StringBuilder> stringStack=new Stack<>();
        StringBuilder currString=new StringBuilder();
        int currNum=0;
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){ //if digit occurs convert to int
                currNum=currNum*10+c-'0';
            } else if(c=='['){  //  push to stack and reset values
                numStack.push(currNum);
                stringStack.push(currString);
                currNum=0;
                currString=new StringBuilder();
            }else if(c==']'){
                int time=numStack.pop();
                StringBuilder newString=new StringBuilder();
                for(int k=0;k<time;k++){
                    newString.append(currString);
                }
                currString=stringStack.pop().append(newString);
            } else {
                currString.append(c);  // if alphabet then append 
            }
        }
        return currString.toString();
  } 
}