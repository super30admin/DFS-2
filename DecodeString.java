// time complexity o(n) space complexity o(n)
class Solution {
    public String decodeString(String s) {
       Stack<StringBuilder> strst = new Stack<>();
       Stack<Integer> numst = new Stack<>();
       int currnum=0;
       StringBuilder currstr = new StringBuilder();
       for(int i=0;i<s.length();i++){
           char c = s.charAt(i);
           if(Character.isDigit(c)){
               currnum=currnum*10+(c-'0');
           }
           else if(c=='['){
               strst.push(currstr);
               numst.push(currnum);
               currstr = new StringBuilder();
               currnum=0;
           }
           else if(c==']'){
               int count = numst.pop();
               StringBuilder newstr = new StringBuilder();
               for(int j=0;j<count;j++){
                   newstr.append(currstr);
               }
               StringBuilder p = strst.pop();
               currstr=p.append(newstr);
               
           }
           else{
               currstr.append(c);
           }
       } 
       return currstr.toString();
    }
}
