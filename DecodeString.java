import java.util.Stack;

public class DecodeString {
    public static String decodeStringStack(String s) { //String parsing
        // O(n) T.C where n is the product of nested digits and addition of non-nested digits (negligible).
        // Cleverly, also equal to the length of result.

        //O(l) S.C where l is length of string, and it is stored in two separate stacks.

        Stack<Integer> intStack = new Stack<>(); //Integer stack to store the digits whose times
        //the corresponding substring has to be repeated

        Stack<StringBuilder> sbStack = new Stack<>(); //StringBuilder stack to store the set of sub-strings
        //which are the children at each decoding level

        int currentNum = 0; //store the current digit until its pushed to stack
        StringBuilder currentString = new StringBuilder(); //store the current sub-string until its pushed to stack

        for(int i=0; i<s.length(); i++) { //iterate over the length of string i.e., parse the string
            char c = s.charAt(i); //take each character

            if(Character.isDigit(c)) { //if the character is a digit
                currentNum = currentNum*10 + (c - '0'); //convert it into integer and store in currentNum, if the next
                // character is also digit, this uses tens multiplication to store as correct integer. i.e, '12' as 12.
            }
            else if(c == '[') { //if opening bracket is encountered
                intStack.push(currentNum); //push the currentNum into stack
                currentNum = 0; //and change it back to 0 to store next digit correctly

                sbStack.push(currentString); //push the current-string into stack
                currentString = new StringBuilder(); //and make it to null to store next sub-string
                //we push the current stack here and not during ']' because during first traversal, we need to store
                //empty string as parent for proper appending.
            }
            else if(c == ']') { //if closing bracket is encountered, here is where decoding starts
                int count = intStack.pop(); //take the top integer out as count
                StringBuilder child = new StringBuilder(); //temp string builder to store the repeating child value

                for(int j=0; j<count; j++) { //repeat until the count
                    child.append(currentString); //append the current string as many times
                }
                StringBuilder parent = sbStack.pop(); //pop the parent out of string stack
                currentString = parent.append(child); //append the child string calculated here to its parent
                //and make this as the new current substring.
            }
            else {
                currentString.append(c); //if alphabet is encountered, append it to currentString
            }
        }
        return currentString.toString();
    }

    static int index; //storing index as global
    public static String decodeStringRecursion(String s) { //Recursion-based
        //O(n*m) T.C, where n is length of string and m is max depth of nested bracket
        //O(m+l) S.C where l is length of decoded string as it is stored in recursive stack

        int currentNum = 0; //stores the current digits
        StringBuilder currentString = new StringBuilder(); //stores the current substring

        while(index < s.length()) { //while loop-based recursion using index incrementer
            char c = s.charAt(index); //char at each index of input string

            if(Character.isDigit(c)) { //same as above
                currentNum = currentNum*10 + (c - '0');
                index++; //increment the index after calculation
            }
            else if(c == '[') {
                index++; //increment the index before further processing as we need to skip over '[' itself
                String child = decodeStringRecursion(s); //child is the recursed value from given index to end of string

                currentString.append(child.repeat(Math.max(0, currentNum)));
                //append the child count times to current string using String.repeat method.
                currentNum = 0; //change the current num back to 0.
            }
            else if(c == ']') {
                index++; //skip over ']'
                return currentString.toString(); //end of current recursion, return the substring value
            }
            else {
                currentString.append(c); //same as above
                index++;
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        String encoded = "3[a2[b3[cbc]]]4[d]";

        String stack = decodeStringStack(encoded);
        String recursion = decodeStringRecursion(encoded);

        System.out.println("Decoded value of given encoded string " + encoded +
                " using stack parsing is: " + stack);

        System.out.println("Decoded value of given encoded string " + encoded +
                " using recursion is: " + recursion);

        System.out.println("Are results using both methods same? " +
                (stack).equals(recursion));
    }
}