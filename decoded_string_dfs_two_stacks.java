TC : O(n)
SC : O(n)


Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Decode String.




class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();
        
        String currStr = "";
        int  currNum = 0;
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum*10+ c - '0';
            }
            else if(c=='['){
                num.push(currNum);
                str.push(currStr);
                currNum=0;
                currStr="";
            }
            else if(c==']'){
                int times = num.pop();
                StringBuilder newStr = new StringBuilder();
                for(int a=0;a< times;a++){
                    newStr.append(currStr);
                }
                currStr=str.pop();
                currStr += newStr;
            }
            else {
                currStr+= c;
            }
        }
        return currStr;
    }
}
