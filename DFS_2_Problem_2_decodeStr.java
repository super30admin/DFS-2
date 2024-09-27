//Time Complexity : O(n) the longer the string, the harder it may take to decode
//Space Complexity : O(n + n) We might have to store everything in 2 stacks
//Runs successfully on leetcode
//No problem(Other than remembering this pattern)

//Here we will be using two stacks, one for string and other for number
//For types of input can be there (Number , [ , character , ])
//Depending upon the input, we will manipulate 2 stacks and achieve the desired result


import java.util.Stack;


public class DFS_2_Problem_2_decodeStr {
    public String decodeString(String s) {
        Stack<String> result = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int index = 0;
        String res = "";
        while(index<s.length())
        {
            char curr = s.charAt(index);
            if(Character.isDigit(curr))
            {
                int number = 0;
                while(Character.isDigit(s.charAt(index)))
                {
                    number = number * 10 + s.charAt(index) - '0';
                    index++;
                }
                count.push(number);
            }
            else if(curr == '[')
            {
                result.push(res);
                res = "";
                index++;
            }
            else if(curr == ']')
            {
                StringBuilder sb = new StringBuilder(result.pop());
                int currNumber = count.pop();
                for(int i = 0 ; i < currNumber ; i ++)
                {
                    sb.append(res);
                }
                res  = sb.toString();
                index ++;
            }
            else
            {
                res = res + s.charAt(index);
                index++;
            }
        }
        return res;
    }
}
