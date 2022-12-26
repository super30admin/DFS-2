// Time Complexity : O(n) // length of the decoded string
// Space Complexity : O(n) // length of the decoded string. 

/*
 * we get 4 cases which can be digit, [, ], alphabet. for digit store it in a number.
 * for [ push the number and get the string. for ] add the string count times to temp string.
 */

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>(); // stringbuilder is used intead of string so it is easier for copying and appending a string to another
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum*10+c - '0'; // get the number from character
            }
            else if(c == '['){
                numSt.push(currNum);
                strSt.push(currStr);
                currStr = new StringBuilder();
                currNum = 0;
            }
            else if(c == ']'){
                int count = numSt.pop();
                StringBuilder child = new StringBuilder();
                StringBuilder parent;
                for(int j = 0; j < count; j++){
                    child.append(currStr);
                }
                parent = strSt.pop();
                currStr = parent.append(child);
            }
            else{ // its an alphabet
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
