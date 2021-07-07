/**
LeetCode Submitted : YES
Space Complexity : O(String Length)
Time Complexity : O(String Length)

The idea is to use two stacks to hold numbers and current strings based on 4 different cases.
if number envountered then push it to num stack with num*10 in case we have more than single digit number. if "[" encountered then push current Num and current Sting to the two different stack as we will now be processing nee string. if "]" encountered then we need to repeat current string multiple times based on the number pop from the number stack and then add it to the pop element from string stack to get the final string. if we encounter any other character add it to current string. Return current string at the end of all the iterations. The key is to use two stacks which I did not use previously and it complicated my logic. 

**/


class Solution {
    public String decodeString(String s) {
    
        if(s == null || s.length() < 1)
            return s;
        
        //Stack to store  number
        Stack<Integer> s1 = new Stack<>();
        
        //Stack to store  String
        Stack<String> s2 = new Stack<>();
        
        int currNum = 0;
        String currString = "";
        
        //Traversing the String
        for(int i = 0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            //Case 1 Adding Digit to the stack
            if(Character.isDigit(c)){
                int num = currNum*10 + Character.getNumericValue(c);
                currNum = num;
            }else if(c == '['){ //if opening bracket encountered
                s1.push(currNum); //Add current number
                s2.push(currString); // Add current string
                currNum    = 0; //Reset current num = 0
                currString = ""; //Reset current string = ""
            }else if(c == ']'){ //closing bracket enocuntered
                StringBuilder sb = new StringBuilder(); 
                int repeat = s1.pop(); //Pop the number of repeat times
                while(repeat > 0){ 
                    sb.append(currString); //Append current string
                    repeat --;
                }
                currString = s2.pop() + sb.toString(); //Add old string to current string
            }else{
                currString = currString + c; //if only character encountered add it to current string
            }
        }
        
        return currString;
        
        
    }
    
}
