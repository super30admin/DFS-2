//The approach here is to use two stacks, number stack and string stack, to insert the current number and the current string as we keep iterating through the given String.
//Depending on the kind of character we encounter at each index in the string, we perform operations using the stack
//If we encounter a digit, we will calculate the current number from the digit.
//If we encounter a character, we will append it to the current string
//If we encounter a '[', then we push the current number into the number stack and current string in the string stack and we make current number 0 and current string an empty string to start the same process for the inner string until we encounter a ']'
//If we encounter a ']', then we pop the current number from the number stack and duplicate the current string the number of times the number we got after popping number stack and then append it to the parent character, which we get by popping from the string stack
//Time Complexity: O(k+n), where k is number of nestings and n is the length of the current string
//Space Complexity: O(k+n);
import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum*10 + ch - '0';
            } else if(ch == '['){
                numSt.push(currNum);
                strSt.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();
            } else if(ch == ']'){
                //pop the number
                int cnt = numSt.pop();
                StringBuilder baby = new StringBuilder();
                for(int k = 0; k<cnt; k++){
                    baby.append(currStr);
                }
                //combine the baby with parent
                StringBuilder parent = strSt.pop();
                currStr = parent.append(baby);
            } else{
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}

//In this approach, we use the same logic as above, but we perform it recursively
//In the same way as above, we iterate through the string, but when we encounter a '[', then we perform the same decode function for the string inside.
//When we encounter a ']', then we return to the parent with the current string.
//Time Complexity: O(k+n), where k is number of nestings and n is the length of the current string
//Space Complexity: O(k+n);
class Solution1 {
    int i;
    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        while(i<s.length()){
            Character ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum = currNum*10 + ch - '0';
                i++;
            } else if(ch == '['){
                i++;
                String decoded = decodeString(s);
                StringBuilder baby = new StringBuilder();
                for(int k = 0; k<currNum; k++){
                    baby.append(decoded);
                }
                currStr.append(baby);
                currNum=0;
                i++;
            } else if(ch == ']'){
                return currStr.toString();
            } else{
                currStr.append(ch);
                i++;
            }
        }
        return currStr.toString();
    }
}