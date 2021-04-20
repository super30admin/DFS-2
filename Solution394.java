/*
Timecomplexity:O(nk)
Space compl:o(nk)
creating two stacks 
and iterating over the string
if num the compute the number
if char then appemd the value
if [ then we push the num and current string into the stack and clear the variable holding the num and current string
if] then pop the number and iterate to append the string the number of times

*/
class Solution {
    public String decodeString(String s) {
        if(s.isEmpty()||s==null){
            return s;
        }
        Stack<Integer> numStack= new Stack<>();
        Stack<String> stringStack= new Stack<>();
        String curr="";
        int num=0;
        
        for(int i=0; i < s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
              
              num=num*10+c-'0';  
            }
           else if(c=='['){
             numStack.push(num);
             stringStack.push(curr);
               num=0;
               curr="";
           
           }
            else if(c==']'){
                int temp=numStack.pop();
                StringBuilder sb=new  StringBuilder();
                for(int j=0;j<temp;j++){
                    sb.append(curr);
                }
                curr=stringStack.pop()+sb.toString();
                
            }
            else{
              curr=curr+c;  
            }
        }
       return curr; 
    }
}