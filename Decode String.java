//Time Complexity : O(nk). n is the length of the string and k is the maximum number of times any string is appended
//Space Complexity : O(nk). n is the length of the string in String stack and k is the maximum number .i.e the stack will hold a string that is append k times 
class Solution {
    public String decodeString(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        //keep two stacks for tracking the characters/string and numbers
        Stack<String> ss = new Stack<>();
        Stack<Integer> sn = new Stack<>();
        int curNum = 0;
        String curString = "";
        //iterate through the given string
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //if the character is a digit/number
            if(Character.isDigit(c)){
                //num is multiplied by if the number is more than one digit 
                //it is subtracted by string 0, to get the correct number from the ASCII range(0-9 has ASCII range from 48 to 57)
                curNum = curNum * 10 + c-'0';
            }
            //if the charcter is '[', push the curnum and curstring into respective stacks
            else if(c == ('[')){
                sn.push(curNum);
                ss.push(curString);
                //reset teh values of curString and curNum
                curString = "";
                curNum = 0;
            }
            //if the charcter is ']', pop from respective stacks
            else if(c == (']')){
                int times = sn.pop();
                //append the string times many times
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<times;j++){
                    sb.append(curString);
                }
                //add this with the pop value from stringstack
                curString = ss.pop() + sb.toString();
            }
            else{
                curString += c;
            }
        }
        return curString;
        
    }
}