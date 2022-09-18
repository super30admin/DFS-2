class Solution {
    int index = 0;
    String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        
    while (index<s.length()   && s.charAt(index)!=']'){
        
        if(Character.isDigit(s.charAt(index))){
            //calculate number
         int k=(int)(s.charAt(index)-'0');
            index++;
            while(Character.isDigit(s.charAt(index))){ k=k*10 +s.charAt(index)-'0'; index++; }
            
            
            index++;
            
        String ans= decodeString(s);
            index++;
            //System.out.println(ans);
            while(k!=0){
                result.append(ans); k--;
            }
       }else{
            
            result.append(s.charAt(index)); index++;
                
        }
    
    }
        
    
   return new String(result);
    }  
}
