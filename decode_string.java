// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
/*Approach:we here traverse given sting and use 2 stack 
 * we have num and curr which keeps updating 
 * for every [ bracket the value in curr and num gets added to numstack and strstack respectively
 * for every ] bracket the value gets poped and newstr stored the times for which the curr string is repeated
 * and append the str in strstack to curr 
 * else any alphabet or num detected is add in respctive stack 
 * return curr.toString()
 */

class Solution {
    public String decodeString(String s) {
        if(s==null|| s.length()==0){
            return " ";
        }
        Stack<Integer> numstack=new Stack<>();
        Stack<StringBuilder> strstack=new Stack <>();
        StringBuilder curr=new StringBuilder();
        int num=0;

        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                    num=num*10+c-'0';
            }
            else if(c == '[')
            {
                strstack.push(curr);
                numstack.push(num);
                curr=new StringBuilder();
                num=0;

            }
            else if(c == ']'){
                int times=numstack.pop();
                StringBuilder newstr=new StringBuilder();
                for(int j=0;j<times;j++){
                    newstr.append(curr);
                }
                curr=strstack.pop().append(newstr);

            }
            else{
                curr.append(c);

            }


        }
        return curr.toString();
        
    }
}