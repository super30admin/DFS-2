/*
Author: Akhilesh Borgaonkar
Approach: Recursive approach here. Read the character literals sequentially and act accordingly. If number detected, store it temporary. 
	If '[' detected, recursive call to parse the substring inside square brackets and append to current string. 
	If ']' detected then return the current string. 
	If alphabet detected, append to output string.
Time complexity: O(n)
Space complexity: O(n) for string builder
Issue previously faced: in looping square brackets, prints output in reverse manner. (Resolved by considering multiple digits and alphabets in string)
*/

public class DecodeString {

     static int i = 0;

    public static String decodeString(String s) {

        StringBuilder output = new StringBuilder();
        int currFreq=0;

        while(i < s.length()){
            char now = s.charAt(i);

            if(now >= '0' && now <= '9'){
                currFreq = currFreq*10 + now - '0';
            }
            else if(now=='[') {
                i++;
                String next = decodeString(s);
                for(int count = 0; count < currFreq; count++)
                    output.append(next);
                currFreq=0;
            }
            else if(now==']') {
                return output.toString();
            }
            else {
                output.append(now);
            }
            i++;
        }

        return output.toString();
    }

}
