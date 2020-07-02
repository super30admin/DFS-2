Executed in leetcode-Yes
time complexity-0(n)
space complexity-o(n)

class Solution {
    public String decodeString(String s) {
        Stack<String> st= new Stack<>();
        Stack<Integer> intSt= new Stack<>();
        char[] chars= s.toCharArray();
        int curNum=0;
        String curStr ="";
        for(char c: chars){
            if(c >='0' && c<='9'){
                curNum = curNum*10+c-'0';
            }else if(c=='['){
                intSt.push(curNum);
                st.push(curStr);
                curStr ="";
                curNum=0;
            }else if(c==']'){
                //pop int from intSt and loop curStr and pop string from st, add and push it in string 
                String newStr= "";
                int k=intSt.pop();
                for(int i=0;i<k;i++){
                    newStr+=curStr;
                }
                curStr=st.pop()+newStr;
            }else{
                curStr+=c;
            }
            }
         return curStr;
        }
}
