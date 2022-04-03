// Time Complexity : O(Max(digit) * n); where n is length of string
// Space Complexity : O(n)
public class DecodeString {		
	/** Approach: Recursive**/
	int i;
    public String decodeString(String s) {
        if(s==null || s.length()==0) return s;
        
        //Recursive
        StringBuilder curr= new StringBuilder();
        int num=0;        
        while(i<s.length()){
            char c= s.charAt(i);
            if(Character.isDigit(c)){//digit
                num= num * 10 + c -'0';
                i++;
                    
            }else if(c=='['){//opening bracket
                i++;                
                String decoded= decodeString(s);//recursive call
                //Repeat it those many times
                for(int k=0; k<num; k++){
                    curr.append(decoded);
                }
                num=0;
                
            }else if(c==']'){//closing bracket
                i++;
                return curr.toString();
                
            }else{//letter
                curr.append(c);
                i++;
            }
        }        
        return curr.toString();
    }

	// Driver code to test above 
	public static void main (String[] args) {
		DecodeString ob= new DecodeString();
		String s= "a3[a2[b]]";// "3[a]2[bc]";
		System.out.println("Decoded string : "+ ob.decodeString(s));	
		
	}
}
