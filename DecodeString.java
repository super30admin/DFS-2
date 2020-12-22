class Solution {
    int i;
    public String decodeString(String s) {          
    StringBuilder str=new StringBuilder();
        int n=0;
        while(i<s.length()){
            char c= s.charAt(i);            
            i++;
            if(Character.isDigit(c)){               
                    n= n*10 +c-'0';
                }
            else if(c== '['){
                String temp= decodeString(s);
                //System.out.println(temp);
                StringBuilder newString = new StringBuilder();
                for(int j=0;j<n;j++){
                    newString.append(temp);
                }
                str.append(newString);
                n=0;
            }
            else if(c==']'){
                return str.toString();
            }
            else
                str.append(c);
            
        }
        return str.toString();
    }
 
}