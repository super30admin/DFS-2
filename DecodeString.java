//BFS

class Solution {

    // Time Complexity : 0(n) where n is the length of the output string
// Space Complexity : 0(d) where d is the depth of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    Stack <StringBuilder> str;      //Used 2 stacks for bfs to store number and character
    Stack <Integer> numStack;
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        str = new Stack<>();
        numStack = new Stack<>();
        int num = 0;
        StringBuilder current = new StringBuilder();        //used a current to store the string after an encoding is done

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);       //extracting each and every character from the input string
            if(c == '['){       //when encounter a opening big bracket
                str.push(current);      //push the current string to the stack
                numStack.push(num);     //push the number to the stack
                num = 0;        //reset the number to 0 as it has already been taken care of in the stack
                current = new StringBuilder();      //do the same with the string
            }
            else if(Character.isDigit(c)){      //check if its a digit
                num = num * 10 + (c - '0');     //convert the character into the digit
            }
            else if(c == ']'){      //if we encounter a closing big bracket, then pop from numstack and append the current string by the no. that is popper
                int times = numStack.pop();
                StringBuilder abc = new StringBuilder();
                for(int j = 0; j < times; j++){
                    abc.append(current);
                }
                current = str.pop().append(abc);    //concatenate the current string with the string stored in the stack
            }
            else{
                current.append(c);      //if a character is encountered, just add it to the current string
            }
        }
        return current.toString();
    }
}

//DFS

class Solution {
    int i;
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        int num = 0;
        StringBuilder current = new StringBuilder();

        while(i < s.length()){
            char c = s.charAt(i);
            if(c == '['){
                i++;
                String d = decodeString(s);
                StringBuilder newString = new StringBuilder();
                for(int j = 0; j < num; j++){
                    newString.append(d);
                }
                current.append(newString);
                num = 0;
            }
            else if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
                i++;
            }
            else if(c == ']'){
                i++;
                return current.toString();
            }
            else{
                current.append(c);
                i++;
            }
        }
        return current.toString();
    }
}