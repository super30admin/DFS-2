// Time Complexity :O(N)
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach




class Solution {
    public String decodeString(String s) {
       
        Stack <Integer> stNum = new Stack();
        Stack <StringBuilder> stStr = new Stack();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for(char  ch : s.toCharArray()){
            
            if(Character.isDigit(ch)){
               num = num*10 + ch-'0';
            }else if(ch == '['){
                stNum.push(num);
                stStr.push(sb);
                sb= new StringBuilder();
                num=0;
            }else if(ch == ']'){
                int temp=stNum.pop();
                for(int i=0;i<temp;i++){
                    sb1.append(sb);
                }
                sb= new StringBuilder();
                sb=stStr.pop();
                sb.append(sb1);
                sb1= new StringBuilder();
            }else{
                sb.append(ch+"");
            }
        }
        
        
        return sb.toString();
    }
}
