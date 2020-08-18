//time complexity: O(nj) where n is the number of characters in the string and j is the number of times a char or combinarion of chars is repeated. in worst, case we can have say 5[ababababab];
//space complexity: O(n) where n is the total number of chars in the string
//executed on leetcode: yes

class Solution {
    public String decodeString(String s) {
        StringBuilder curr = new StringBuilder();
        if(s==null || s.length()==0) return curr.toString();
        Stack<StringBuilder> c = new Stack<StringBuilder>();
        Stack<Integer> nums = new Stack<Integer>();
        int n = 0;    
        for(int i=0;i<s.length();++i)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                n = 10*n + s.charAt(i) - '0';
            }
            else if(Character.isLetter(s.charAt(i)))
            {
                curr.append(s.charAt(i));
            }
            else if(s.charAt(i)=='[')
            {
                c.push(curr);
                nums.push(n);
                n=0;
                curr= new StringBuilder();
            }
            else
            {
                int times = nums.pop();
                StringBuilder newString = new StringBuilder();
                for(int j=0;j<times;++j)
                {
                    newString.append(curr);
                }
                curr = c.pop().append(newString);
            }
        }
        return curr.toString();
        
    }
}