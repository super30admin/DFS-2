// Time Complexity : O(n) where n is the total length of the string s + O(1) for number of times I am iterating a particular substring (assuming it to have a defined limit) = O(n) total
// Space Complexity : O(n) (Stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  Parsing the String with []
/* Your code here along with comments explaining your approach: Use a stack for an ordered execution. Put the outer string first(previous string starting with null) in the stack along with a count
that indicates the number of times. As the string is getting popped from the stack, we store it as the previous string, the current string is executed the number of times and is appended to the stringbuilder
Then that new stringbuilder gets appended to the previous string and the process is repeated till the stack is empty. We return the final result as
the empty string that must've got appended with the strings popped from the stack by now.
*/

// DFS ITERATIVE
class Solution {
    class Pair{
        int count;
        StringBuilder label;
        Pair(int c, StringBuilder l){                                       // Maintain a pair of count and stringbuilder
            this.count = c;
            this.label = new StringBuilder(l);
        }
        public int getCount(){return this.count;}
        public StringBuilder getStr(){return this.label;}                   // Return the ncessary
    }
    public String decodeString(String s) {
    if(s == null || s.length() == 0){return s;}
    StringBuilder temp = new StringBuilder();
    int count = 0;
    Stack<Pair> stk = new Stack<>();                                    // Stack for pair 
    for(int i = 0; i < s.length(); i++){
        if(s.charAt(i) == '['){                                             // If the inner string is about to start
        stk.push(new Pair(count, temp));                                    // Push the recent count along with the previous string( string found till now)
        count = 0;      
        temp = new StringBuilder();                                     // Reset the count and stringbuilder to incorporate future measures
        } else 
        if(Character.isDigit(s.charAt(i))){                         // If it is a digit
                count = count * 10 + (s.charAt(i) - '0');
        } else
        if(s.charAt(i) == ']'){                                             // If the end of the stirng is indicated, time ot pop from the stack and append
            Pair fetch = stk.pop();
            StringBuilder text = fetch.getStr();                            // Get the previous string
            int index = fetch.getCount();                                   // Get the count of the current string
            StringBuilder inner = new StringBuilder();
            for(int k =0; k < index; k++){
                inner.append(temp);                                         // Append the current string count number of times
            }
            temp = text.append(inner);                                      // Append the new string to the current string
        }
        else 
        {
         temp.append(s.charAt(i));                                         // Append the letters
        }
    }
        return temp.toString();                                            // Return the final string
    }
    }

    // DFS RECURSIVE
    class Solution {
        int i = 0;                                                                      // Global iteration of string
        public String decodeString(String s) {
        if(s == null || s.length() == 0){return s;}
        int count = 0;
        StringBuilder result = new StringBuilder();
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                count = count * 10 + (c - '0');                                         // If it is a digit
                i++;
            } 
            else
            if(c == '['){ 
            i++;
            String res = decodeString(s);                                           // Recursively appending the inner string and then outer string
            for(int k =0; k < count; k++){
                    result.append(res);
                }
            count = 0;                                                              // Reset the count
            } else
            if(c == ']'){
                i++;
                return result.toString();                                           // String is over, return the result
            }
            else 
            {i++;
             result.append(c);                                                      // Append the letters
            }
        }
            return result.toString(); 
        }
        }