// DFS
// TC: O(N*max(times)) -> O(NK)
// SC: O(N) -> N is the length of string
class Solution {
    int i;
    public String decodeString(String s) {
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        while ( i < s.length())
        {
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
            {
                num = num * 10 + (ch - '0');
                i++;
            }
            else if (ch == '[')
            {
                i++;
                String innerString = decodeString(s);
               // multiply it num times
                for ( int j = 0; j < num; j++)
                {
                    currStr.append(innerString);
                }
                num = 0;
            }
            else if (ch == ']')
            {
                i++;
                return currStr.toString();
            }
            // if (Character.isAlphabetic(ch))
            else 
            {
                currStr.append(ch);
                i++;
            }
        }
        return currStr.toString();
    }
}

// 2 Stacks Solution
// TC: O(N*max(times)) -> O(NK)
// SC: O(N) -> N is the length of string
// class Solution {
//     public String decodeString(String s) {
//         Stack<Integer> numStack = new Stack();
//         Stack<StringBuilder> stringStack = new Stack();
//         int num = 0;
//         StringBuilder currStr = new StringBuilder();
//         for ( int i = 0; i < s.length(); i++)
//         {
//             char ch = s.charAt(i);
//             if (Character.isDigit(ch))
//             {
//                 num = num * 10 + (ch - '0');
//             }
//             else if (ch == '[')
//             {
//                 numStack.push(num);
//                 stringStack.push(currStr);
//                 // reset the num and currStr
//                 num = 0;
//                 currStr = new StringBuilder();
//             }
//             else if (ch == ']')
//             {
//                 int times = numStack.pop();
//                 StringBuilder newStr = new StringBuilder();
//                 for ( int j = 0; j < times; j++)
//                 {
//                     newStr.append(currStr);
//                 }
//                 currStr = stringStack.pop().append(newStr);
//             }
//             // if (Character.isAlphabetic(ch))
//             else 
//             {
//                 currStr.append(ch);
//             }
//         }
//         return currStr.toString();
//     }
// }

