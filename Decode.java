// Time Complexity : O(n * k) n is length of s and k is max number in the string
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach - we are using 2 stacks
// based on the currChar in the for loop we will either generate the digit in currNum or else 
//decode the baby, or store parent. 

public class Decode {
    //using 2 stacks 
     public String decodeString(String s) {
         int n = s.length();
         Stack<Integer> numSt = new Stack<>();
         Stack<StringBuilder> strSt = new Stack<>();
         
         int currNum = 0;
         StringBuilder currStr = new StringBuilder();
 
         for(int i = 0; i < n; i++){
             char c = s.charAt(i);
             if(Character.isDigit(c)){
                 currNum = currNum * 10 + c - '0';
             }else if(c == '['){
                 //decode baby, so store the parent 
                 numSt.push(currNum);
                 currNum = 0;
                 strSt.push(currStr);
                 currStr = new StringBuilder();
             }else if(c == ']'){
                 //pop 
                 int count = numSt.pop();
                 StringBuilder baby = new StringBuilder();
                 for(int k = 0; k < count; k++){
                     baby.append(currStr);
                 }
                 StringBuilder parent = strSt.pop();
                 parent.append(baby);
                 currStr = parent;
             }else{
                 //character 
                 currStr.append(c);
             }
         }
         return currStr.toString();
     }

     //recursion based 
    //  int i = 0;
    //  public String decodeString(String s) {
    //      int n = s.length();
    //      int currNum = 0;
    //      StringBuilder currStr = new StringBuilder();
 
    //      while(i < n){
    //          char c = s.charAt(i);
    //          i++;
    //          if(Character.isDigit(c)){
    //              currNum = currNum * 10 + c - '0';
    //          }else if(c == '['){
    //              //decode baby, so store the parent 
    //              String baby = decodeString(s);
    //              for(int k = 0; k < currNum; k++){
    //                  currStr.append(baby);
    //              }
    //              currNum = 0;
    //          }else if(c == ']'){
    //              //pop 
    //              return currStr.toString();
    //          }else{
    //              //character 
    //              currStr.append(c);
    //          }
    //      }
    //      return currStr.toString();
    //  }
 
}
