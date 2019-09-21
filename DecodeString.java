/*
Author: Akhilesh Borgaonkar
Known Issue: in looping square brackets, prints output in reverse manner.
*/

import java.util.ArrayList;
import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {

        Stack<Integer> frequency = new Stack<Integer>();
        Stack<String> strings = new Stack<String>();
        String currStr;
        String output = "";
        int currFreq=0;

        for(int i=0; i<s.length() ; i++){
            if(Character.isDigit(s.charAt(i))){
                currFreq = Character.getNumericValue(s.charAt(i));
                System.out.println(currFreq);
            }
            else if(s.charAt(i)=='[') {
                frequency.push(currFreq);

                currStr="";
                currFreq=0;
            }
            else if(s.charAt(i)==']') {
                currStr = strings.pop();
                for(int j = frequency.pop(); j>0; --j)
                    output+=currStr;
                System.out.println(output);
            }
            else {
                strings.push(Character.toString(s.charAt(i)));
            }
        }

        return output;
    }

}
