class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0) return s;
        
        
        StringBuilder currStr= new StringBuilder();
        
        
        
        int num=0;
        
        
        
        Stack<Integer> numst= new Stack<>();
        Stack<StringBuilder> strst= new Stack<>();
        
        
        
        for(int i=0;i<s.length();i++){
            
            char c = s.charAt(i);
  
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            else if (c=='['){
                // openning bracket we want to add string and number to stack
                numst.add(num);
                strst.add(currStr);
                currStr= new StringBuilder(); 
                num=0;
            }
            else if(c==']'){
                int time=numst.pop();
                StringBuilder newstr= new StringBuilder();
                for(int j=0;j<time;j++){
                    newstr.append(currStr);
                }
                currStr=strst.pop().append(newstr);
            }
            else currStr.append(c);
            

            
            
        }
            return currStr.toString();
    }

}
