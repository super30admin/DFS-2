/*

    L.C:394 Decode String

    Approach: Using 2 Stacks

    Working:
        Declaring a num stack -> numStack and string stack -> strStack
        Initializing variable
        num = 0 -> integer
        curr = "" -> String Buffer

        iterating throught the word till its length

            char currentChar = get current index character

            when currentChar is Digit - calculate number

                num = num * 10 +
                                (currentChar - '0'); getting the integer value with ASCII

            when currentChar is open Braces [ - push

                push num and curr to numStack and strStack

                reset num and curr value

            when currentChar is closed Braces ] - pop

                repetationCount = pop from numStack
                constructedString = counstruct a string with curr value with repetationCount

                poppedStr = pop value from string stack

                curr = poppedStr.append(constructedString)


            else //current char is a  string
                append currentChar to curr

        return curr;

    Time Complexity: O(n) - length og the word
    Space Complexity: O(n/2) - > O(n) //if case 2[a]2[c]3[b] - max elemnts int he stack is 2,2,3/ a,c,b

 */


class DecodeString {
    public String decodeString(String s) {

        if(s == null || s.length() == 0)
        {
            return "";
        }

        Stack<StringBuffer> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        int num = 0;
        StringBuffer curr = new StringBuffer();

        int i=0;

        while(i<s.length()) {

            char c = s.charAt(i);

            if(Character.isDigit(c)) {

                num = num * 10 + (c - '0');
            }
            else if( c == '[') {

                strStack.push(curr);
                numStack.push(num);

                num = 0;
                curr = new StringBuffer();

            }
            else if(c == ']') {

                int count = numStack.pop();
                StringBuffer sb = new StringBuffer();

                for(int k=0; k<count; k++){
                    sb.append(curr);
                }

                curr = strStack.pop().append(sb);
            }
            else {
                curr.append(c);
            }
            i++;
        }

        return curr.toString();

    }
}