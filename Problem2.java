//DecodeString
//SC : o(m+n) where m= number of letters from a-z and n is number of digits from 0-9
//TC : o(length of string * max k) 
public class Problem2 {
    public String decodeString(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num=0;
        StringBuilder currStr = new StringBuilder();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }else if(c=='['){
                numStack.push(num);
                strStack.push(currStr);
                num=0;
                currStr= new StringBuilder();
            }else if(c==']'){
                int times = numStack.pop();
                StringBuilder newStr = new StringBuilder();
                for(int j=0;j<times;j++){
                    newStr.append(currStr);
                }
                currStr=strStack.pop().append(newStr);
            }else{
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
}
