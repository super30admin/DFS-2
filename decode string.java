/* Time complexity O(n*length) n is largest number in input
SPace complexity O(length)*/

class Solution {
    public String decodeString(String s) {
        StringBuilder currStr=new StringBuilder();
        Stack<Integer> nums=new Stack<>();
        Stack<StringBuilder> str=new Stack<>();
        int num=0;
        for(int i =0;i<s.length();i++){
            Character c=s.charAt(i);
            if(c=='['){
                nums.push(num);
                str.push(currStr);
                num=0;
                currStr=new StringBuilder();
                
            }
            else if(c==']'){
                int times=nums.pop();
                StringBuilder newStr=new StringBuilder();
                for(int j=0;j<times;j++){
                    newStr.append(currStr);
                }
                currStr=str.pop().append(newStr);
            }
            else if(Character.isDigit(c)){
                num=num*10 +c -'0';
                
            }
            else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}