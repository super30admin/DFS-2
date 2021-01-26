  //when the c is a char build the string
            //if c is a number, add it to num by num * 10 + num;
            //if c is '[', put the currStr in str stack and reset it to. "";
            //put. num is numstack and reset it to 0
            //if ']', pop from num stack and tat many times add the currStr


//time complexity : O(n), ignore the constant of higest k 
//space complexity ; O(n)
class decodeString {
//     public String decodeString(String s) {
//         if(s.length() == 0 || s == null){
//             return null;
//         }
        
//         int num = 0;
//         StringBuilder currStr = new StringBuilder();   
//         Stack<StringBuilder>strStack = new Stack<>();
//         Stack<Integer>numStack = new Stack<>();
         
//         for(int i = 0;i < s.length();i++){      
//             char c = s.charAt(i);      
//             if(Character.isDigit(c)){
               
//                 num = num * 10 + c - '0';
//             }
//             else if (c == '['){ 
//                 // decode the inner string freshly
//                 //pushing the parent string
//                 strStack.push(currStr); 
//                 numStack.push(num);
//                 num = 0;  
//                 currStr = new StringBuilder();
//             }
//             else if (c == ']'){
                
//                 int times = numStack.pop();
//                 StringBuilder newString = new StringBuilder();
//                 for(int k = 0; k < times;k++){
//                     newString.append(currStr);
//                 }
//                 currStr = strStack.pop().append(newString);
//             }
            
//             //c is a char
//             else{
//                 currStr.append(c);
//             }
//         }
        
//         return currStr.toString();
//     }
    
    
    int i = 0;
    
    public String decodeString(String s){
        if(s == null || s.length() == 0) return s;
 
        int num = 0;
        StringBuilder currStr = new StringBuilder();
        
        while( i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                num = num * 10 + c - '0';
                i++;
            }
            else if(c == '[')
            {
                //once opening bracet is encountered, process the further string
                i++; //escape the curr go to next
                String inner = decodeString(s);
                StringBuilder newStr = new StringBuilder();
                for(int k = 0 ; k < num; k++){
                    newStr.append(inner);
                }
                
                currStr.append(newStr);
                num = 0; 
            }
            else if( c == ']')
            {
                i++;//go to next char for future processing
                return currStr.toString();
            }
            else {
                //just append the char to currStr
                currStr.append(c);i++;
            }
        }
        return currStr.toString();
    }
}