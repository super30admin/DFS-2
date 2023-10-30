// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public String decodeString(String s) {
        Stack<StringBuffer> sstk = new Stack<>();
        Stack<Integer> istk = new Stack<>();
        StringBuffer curr = new StringBuffer();
        int num = 0;
        sstk.push(curr);
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c - '0');
                System.out.println("Number is"+num);}
            else if (c == '['){
                sstk.push(curr);
                istk.push(num);
                curr = new StringBuffer("");
                num = 0;
            }
            else if(c == ']'){
                int dig = istk.pop();
                StringBuffer tmp = new StringBuffer(curr);
                for(int j = 0; j < dig-1; j++)
                    tmp.append(curr);
                StringBuffer sb = sstk.pop();
                curr = sb.append(tmp);

            }
            else
                curr.append(c);
        }
        return curr.toString();
    }
}