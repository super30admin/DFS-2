// Time Complexity : O(n) --> n = Length of evaluated string
// Space Complexity :O(h) --> h= level of nesting 
class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0) return s;
        
        Stack<StringBuilder> str=new Stack<>();
        Stack<Integer> snum=new Stack<>();
        StringBuilder cur=new StringBuilder();
        int num=0;
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            //number
            if(Character.isDigit(c)){
                int n= c- '0';
                num=num*10+n;
            }
            //opening brace
            else if(c=='['){
                snum.push(num);
                str.push(cur);
                num=0;
                cur=new StringBuilder();
            }
            //closing brace
            else if(c==']'){
               int times= snum.pop();
               StringBuilder newStr= new StringBuilder();
                 for(int j=0;j<times;j++){
                     newStr.append(cur);
                 }
                 cur=str.pop().append(newStr);
            }
            //char
            else{
               cur.append(c); 
            }   
            
        }
        
        return cur.toString();
        
    }
}