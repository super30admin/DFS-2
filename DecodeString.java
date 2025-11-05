// 394. Decode String
// https://leetcode.com/problems/decode-string/description/

// Solution 1 => Using Stack

/**
 * Time Complexity: O(n * m) where n is length of string and m is max repeat count.
 * Space Complexity: O(n + m) where n is length of string and m is max length of decoded string at any point
 */

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> parentStack = new Stack<>();

        StringBuilder currString = new StringBuilder();

        int num = 0;

        for(int i = 0 ; i < s.length() ; i++){ 

            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 + c - '0'; // create a number
            }else if(s.charAt(i) == '['){
                numStack.push(num);  // store number so that when child string is formed we can duplicate it
                num = 0;
                parentStack.push(currString); // store parent i.e previously formed string
                currString = new StringBuilder(); // start a new string for child
            }else if(s.charAt(i) == ']'){ // child string is done
                int n = numStack.pop(); 

                StringBuilder parent = parentStack.pop();                     

                for(int j = 0 ; j < n ; j++){ // add child string to parent
                    parent.append(currString);
                }

                currString = parent; 
            }else{
                currString.append(c);
            }
        }

        return currString.toString();
    }
}

// Solution 2 => DFS

/**
 * Time Complexity: O(n * m) where n is length of string and m is max repeat count.
 * Space Complexity: O(d + m) where d is depth of nested brackets and m is max length of decoded string
 */


class Solution {
    int i = 0;

    public String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        int num = 0;

        // start iterating string
        while(i < s.length()){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
                i++;
            }else if(ch == '['){
                i++;
                String child = decodeString(s); // reach till last child recusively

                for(int i = 0 ; i < num ; i++){
                    currStr.append(child);
                }

                num = 0;
            }else if(ch == ']'){ // return child once processed
                i++;
                return currStr.toString();
            }else{
                currStr.append(ch);
                i++;
            }
        }

        return currStr.toString();
    }
}