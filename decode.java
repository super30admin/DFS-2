// Time Complexity :O(max(k,n)) ->k is the product of all digits and n is the length of the string
// Space Complexity :O(max(k,n))
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: here i have implemented this problem by using two stack where i encounter digit just add it to currnum and if char just append to currstring whenever i encounter [ then pushing the curr string and num to correspondng stacks in addition to that resetting currNum and currstring as well,
//  however when i encounter ] popping the curr number and reapting currString those many times which is baby string as well popping string from stringstack  which is parent string and appending baby to 
//  parent as well assigning that to currentString

class Solution {
    public String decodeString(String s) {
        int currentNum=0;
        StringBuilder currentString = new StringBuilder();
        Stack<StringBuilder> st=new Stack<StringBuilder>();
         Stack<Integer> nst=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i) ;
            if(Character.isDigit(ch)){
                currentNum=currentNum*10+ch - '0';
            }else if(ch == '['){
                st.push(currentString);
                nst.push(currentNum);
                currentNum=0;
                currentString=new StringBuilder();
            }else if(ch == ']'){
                int num=nst.pop();
                StringBuilder baby=new StringBuilder();
                for(int j=0;j<num;j++){
                baby.append(currentString);
                }
                StringBuilder parent=st.pop();
                currentString=parent.append(baby);
            }else{
                currentString=currentString.append(ch);
            }
        }
        return currentString.toString();
        
    }
}


// Time Complexity :O(max(k,n)) ->k is the product of all digits and n is the length of the string
// Space Complexity :O(max(k,n))
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:recursion approach without stack usage.


class Solution {
    int i;
    public String decodeString(String s) {
        int currentNum=0;
        StringBuilder currentString = new StringBuilder();
         while(i<s.length()){
            char ch=s.charAt(i) ;
            if(Character.isDigit(ch)){
                currentNum=currentNum*10+ch - '0';
                i++;
            }else if(ch == '['){
                i++;
             String decoded= decodeString(s);
             StringBuilder baby=new StringBuilder();
              for(int k=0;k<currentNum;k++){
              baby.append(decoded);
              }
             currentString.append(baby);
             System.out.println("parent"+currentString);
                currentNum=0;
                i++;
            }else if(ch == ']'){
              return currentString.toString();
            }else{
                currentString=currentString.append(ch);
                i++;
            }
        }
        return currentString.toString();
        
    }
}