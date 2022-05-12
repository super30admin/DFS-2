//time complexity : O(Max(k) * n) where k is the highest time repeatition and n
//                    is the length of the string
//space : O(M + N) where M and N are respective sizes of the letter and num stack
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> chars = new Stack<>();
        Stack<Integer> nums = new Stack<>();

        if(s == null) return s;

        int count = 0;

        StringBuilder result = new StringBuilder();

        int n = 0;

        while( count < s.length())
        {
            char ch = s.charAt(count++);
            //until closing bracket encountered, push into stacks and reset when opening bracket encountered, as until then the inner string will be deciphered
            if(ch != ']')
            {
                if(Character.isDigit(ch))
                {
                    n = n * 10 + ch - '0';
                }
                else if(Character.isLetter(ch))
                {
                    result.append(ch);
                }
                else
                {
                    chars.push(result);
                    nums.push(n);
                    n = 0;
                    result = new StringBuilder();
                }
            }
            //as soon as closing bracket is encountered, remove the parent from the stack and add the current deciphered string to it.
            else
            {
                int repeat = nums.pop();
                StringBuilder deciphered = chars.pop();

                while(repeat > 0)
                {
                    deciphered.append(result);
                    repeat--;
                }

                result = deciphered;
            }

        }

        return result.toString();
    }
}
