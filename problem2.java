class Solution {
    //Time- O(K.N)
    //Space- O(M+N)
    public String decodeString(String s) {
        //iterate
        //number: calc num
        //'[' push curr and num to the stacks and reset the values
        //char- append to the curr
        //']'-pop from numstack and perform resString and append the charStack pop value and set currString with resString
        int num=0;
        
        Stack<StringBuilder> stringStack= new Stack<>();
        Stack<Integer> numStack= new Stack<>();
        StringBuilder curr= new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num=num*10+ s.charAt(i)- '0';
            }
            
            else if(s.charAt(i)== '['){
                
                numStack.push(num);
                stringStack.push(curr);
                num=0;
                curr= new StringBuilder();
            }
            
            else if(s.charAt(i)== ']'){
                StringBuilder res= new StringBuilder();
                int n= numStack.pop();
                
                for(int j=0; j<n; j++){
                    res.append(curr);
                }
                StringBuilder parent= stringStack.pop();
                curr= parent.append(res);
                
            }
            
            else curr.append(s.charAt(i));
            
        }
        
        return curr.toString();
        
        
    }
}