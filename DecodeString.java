// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {

    class Pair
    {
        int num;
        StringBuilder result;

        Pair(int num, StringBuilder result)
        {
            this.num = num;
            this.result = result;
        }
    }

    public String decodeString(String s) {
        
        Stack<Pair> s1 = new Stack();
        int num = 0;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if(Character.isDigit(c))
            {
                num = num * 10 + c - '0';
            }
            else if(c == '[')
            {
                s1.push(new Pair(num, result));

                num = 0;
                result = new StringBuilder();
            }
            else if(c == ']')
            {
                Pair p = s1.pop();
                int count = p.num;
                StringBuilder temp = new StringBuilder();

                for(int k = 0; k < count; k++)
                    temp.append(result);
                
                result = p.result.append(temp);
            }

            else result.append(c);
        }

        return result.toString();
    }
}