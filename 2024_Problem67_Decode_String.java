//394. Decode String - https://leetcode.com/problems/decode-string/description/
//Time Complexity: O(n*k) ~ 'k' being largest number and 'n' is the length of the string
                 //O(L) ~ where 'L' is the size of the Output String
//Space Complexity:

//Extra space using 2 Stacks
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> letterStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        int n = s.length();

        StringBuilder currStr = new StringBuilder();
        Integer currNum = 0;

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            //if current chat is a digit
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
            //if there is an opening bracket
            }else if(c == '['){//push current situation into Stack
                letterStack.push(currStr);
                numberStack.push(currNum);
                //re-initialize to 0 and empty string
                currStr = new StringBuilder();
                currNum = 0;
            //if there is a closing bracket
            }else if(c == ']'){
                //pop numberStack to get the frequency to decode
                int poppedFreq = numberStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j=0; j < poppedFreq; j++){
                    newStr.append(currStr);
                }
                //pop letterStack in case there is any letter after '['
                //eg., [c3[de] -> processing ']' -> output expected: 'cdedede'
                StringBuilder temp = letterStack.pop();
                temp.append(newStr);
                currStr = temp;
            //if next Char is a chatacter, append
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}


//DFS
class Solution {
    int index = 0;
    public String decodeString(String s) {
        int n = s.length();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        while(index < n){
            char c = s.charAt(index);
            index++;
            //if current chat is a digit
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
                //if there is an opening bracket
            }else if(c == '['){
                String baby = decodeString(s);
                for(int k=0; k<currNum; k++){
                    currStr.append(baby);
                }
                currNum = 0;
                //if there is a closing bracket
            }else if(c == ']'){
                return currStr.toString();
                //if next Char is a chatacter, append
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}