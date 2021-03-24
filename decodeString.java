// Time Complexity :O(n * k) where k is the biggest number in the input string
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this approach we maintain two stacks. Along with two stacks , we maintain the numbers and the alphabets in two variable.Once we see an opening bracket , we push the alphabets
//and number from the varible into the stacks,the letters in one stack and the numbers in the other one.At this point we initialise the temp varibale for number to 0 and the temp for alphabet to 
//blank.We keep appending the alphabets to the temo variable. When we see a closing bracket , we pop the number from the top of the number stack , and for that number of times , we
//append the temp to a new variable.We then pop the alpabhets stack and append the previous varible to it.



class Solution {
    public String decodeString(String s) {
      if(s == null || s.length()==0)
      {
        return s;
      }
      
      
      Stack<StringBuilder> stringStack = new Stack<>();
      Stack<Integer> integerStack = new Stack<>();
      
      StringBuilder currStr = new StringBuilder();
      int currNum = 0;
      
      for(int i=0;i<s.length();i++)
      {
        char c = s.charAt(i);
        
        if(Character.isDigit(c))
        {
          currNum = currNum*10 + c -'0';
        }
        else if (c=='[')
        {
          stringStack.push(currStr);
          integerStack.push(currNum);
          currNum=0;
          currStr = new StringBuilder();
        }
        else if(c==']')
        {
          int multiplier = integerStack.pop();
          StringBuilder newStr = new StringBuilder();
          for(int j=0;j<multiplier;j++)
          {
            newStr.append(currStr);
          }
          currStr = stringStack.pop().append(newStr);
        }
        else
        {
          currStr.append(c);
        }
        
        
      }

      
      return currStr.toString();
        
    }
}