// Time Complexity :
//Using 2 stacks : O(n), length of string
//Recursive : O(n)
// Space Complexity :
//Using 2 stacks : O(2n) ~ O(n)
//Recursive : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Solution using two Stacks
class Solution {
    public String decodeString(String s) {
        
        //check is stack is null or empty, in case return input string s
        if(s == null || s.length() == 0) return s; 
        //currNum and currStr to keep the top num/str value 
        //string builder : mutable string ds
        int currNum = 0;     
        StringBuilder currStr = new StringBuilder();
        
        //2 separate stacks for number and alphabets
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        
        //loop over the input 
        for(int i = 0; i <s.length(); i++) {
            //get the char at position i
            char c = s.charAt(i);
            
            //if the char is a number
            if(Character.isDigit(c)) {
                //add it to the currNum 
                //(currNum * 10 to convert to tens place)
                //c-'0' to get integer value of the char
                currNum = currNum * 10 + c-'0';              
            }
            
            //if char is opening square bracket
            //push currnum and currstr to stacks
            //and reset the values to 0 and ""
            else if(c == '[') {
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            }
            
             //if char is closing square bracket
            //get the currnum and currstr
            //multiply the currstr those many times
            //2[a] => aa 
            else if(c == ']') {
                int multimes = numStack.pop();
                StringBuilder innerString = new StringBuilder();
                //loop to append the same currstr those many times
                for(int j = 0; j < multimes; j++) {
                    innerString.append(currStr);
                }
                //append the top currStr from stack 
                //to the new string (multipled string)
                //eg : 3[a2[c]] = a is added cc   and then multipled by 3
                //to get : accaccacc
                currStr = strStack.pop().append(innerString);
            }
            
            //if char is a alphabet
            //append to the currStr and push to stack when we encounter "["
            else {
                currStr.append(c);
            }  
        } //convert the currStr to toString and return
        return currStr.toString();             
    }
}




////////////////////////////////////////



//Solution: Recursive
class Solution {
    //i is globally declared to call inner strings 
    //(with starting position = i) in the actual input string
    int i = 0; 
    public String decodeString(String s) {
        
        //check is stack is null or empty, in case return input string s
        if(s == null || s.length() == 0) return s; 
        //number and resString has recent resursion call results 
        //string builder : mutable string ds
        int number = 0;     
        StringBuilder resString = new StringBuilder();
        
        //while loop over the input, till end of string
        while(i < s.length()) {
            //get the char at position i
            char c = s.charAt(i);
            
            //if the char is a number
            if(Character.isDigit(c)) {
                //add it to the number 
                //(number * 10 to convert to tens place)
                //c-'0' to get integer value of the char
                //increment i count to go to next character
                i++;
                number = number * 10 + c-'0';                
            }
            
            //if char is opening square bracket
            //call recursive funtion on the string after the "["
            //multiply that inner string recursive result 
            //number value times with number before [
            //and reset the number value to 0 (inner string calls new recursive call)
            //increment i count to go to next character
            else if(c == '[') {
                i++; 
                String innerRecur = decodeString(s);
                for(int j = 0; j < number; j++) {
                    resString.append(innerRecur);
                }
                number = 0;
            }
            
             //if char is closing square bracket
            //return the result
            //increment i count to go to next character
            else if(c == ']') {
                i++;
                return resString.toString();
            }
            
            //if char is a alphabet
            //append to the resString with the char
            else {
                i++;
                resString.append(c);
            }  
        } //convert the resString to toString and return
        return resString.toString();             
    }
}
