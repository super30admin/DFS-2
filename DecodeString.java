class Solution {
    public String decodeString(String s) {
        int currNum=0;
        StringBuilder currStr=new StringBuilder();
        Stack<Integer> numSt=new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                currNum=currNum*10+c-'0';
            }else if(c=='['){
                numSt.push(currNum);
                strSt.push(currStr);
                currNum=0;
                currStr=new StringBuilder();
            }else if(c==']'){
                int cnt=numSt.pop();
                StringBuilder baby=new StringBuilder();
                for(int k=0;k<cnt;k++){
                    baby.append(currStr);
                }
                
                StringBuilder parent=strSt.pop();
                parent.append(baby);
                currStr=parent;
            }else{
                currStr.append(c);
            }
        }
        
        return currStr.toString();
    }
}