/*
* Approach:
*  1. Maintain global variable as index = 0. 
        Keep iterating the string using this index.
* 
*  2. if character at index is digit,
            increment index
            add to currNum
        if character, 
            increment index
            add to currStr
        if [, 
            increment index
            recurse with s for getting baby.
            append the baby to decoded str currNum times,
            append decoded str to currStr.
        if ], 
            increment index
            return currStr
* 
*  3. if index reaches end, return currStr
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(N)
    N - product of all k's
* 
* Space Complexity: O(N)
* 
*/

public class DecodeStringDFS {
    int index = 0;

    private StringBuilder dfs(StringBuilder s) {        
        StringBuilder currStr = new StringBuilder();

        int currNum = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
                index++;
            } else if (ch == '[') {
                index++;
                StringBuilder baby = dfs(s);

                StringBuilder decodedStr = new StringBuilder();

                for(int i=0; i < currNum; i++)
                    decodedStr.append(baby);

                currStr.append(decodedStr);
                currNum = 0;

            } else if (ch == ']') {
                index++;
                return currStr;
            } else {
                currStr.append(ch);
                index++;
            }
        }

        return currStr;
    }

    public String decodeString(String s) {
        return dfs(new StringBuilder(s)).toString();
    }
}
