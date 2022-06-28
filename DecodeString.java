import java.util.Stack;

//Time Complexity: O(l), length of the output string
//Space Complexity: O(h), maximum depths of the nestings

class Solution {
    public String decodeString(String s) {
        
        //creating two stacks
        //one to store characters and brackets 
        //and the second one to store digits present in the string
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        
        //creating a stringbuilder which will be updating to get the final result
        //we use it because string by itself is an immutable datastructure
        StringBuilder currStr = new StringBuilder();
        
        //creating a num variable which we will ustilize to 
        int num = 0;
        
        //looping through each character of the string
        for(int i = 0; i < s.length(); i++) {
            //getting the character at a specific location on the string
            char c = s.charAt(i);
            
            //if the current element in string is an opening bracket
            if(c == '[')
            {
                //we push the current string built using stringbuilder to the stack
                strSt.push(currStr);
                //we also push the number calculated so far(with the right amount of zeroes)
                numSt.push(num);
                //set the currStr to their initial values again
                currStr = new StringBuilder();
                num = 0;
            }
            //if the current element in string is a closing bracket
            else if(c == ']')
            {
                //we pop the last number from the stack and store it at k
                int k = numSt.pop();
                //we create a temporary string builder which we will use to append to the currStr
                StringBuilder temp = new StringBuilder();
                //looping and adding the temp stringbuilder to currStr as many times as required by the number we claculated(with the right amount of zeroes)
                for(int j = 0; j < k; j++)
                {
                    temp.append(currStr);
                }
                //popping the last string on the stack and storing it in parent and appending temp to it and storing it in currStr
                StringBuilder parent = strSt.pop();
                currStr = parent.append(temp);
            }
            //updating num based on the digit we are at
            else if(Character.isDigit(c))
            {
                num = num * 10 + c - '0';
            }
            //appening directly to the currStr if character is a char
            else
            {
                currStr.append(c);
            }
        }
        //returning the resultant string
        return currStr.toString();
    }  
}