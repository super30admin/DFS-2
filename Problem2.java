import java.util.Stack;

//Time: O(n)
//Space :O(n)

public class Problem2 {
	
	    public String decodeString(String s) {
	        if(s==null || s.length() ==0)
	            return "";
	        Stack<Integer> stknum = new Stack<>();
	        Stack<String> stkstr= new Stack<>();
	        String res="";
	        int i=0;
	        while(i<s.length()){
	            if(Character.isDigit(s.charAt(i))){
	                int count=0;
	            while(Character.isDigit(s.charAt(i))){
	                
	                count=count*10+(s.charAt(i)-'0');
	                i++;                
	            }
	            stknum.push(count);
	                
	            }
	            else if(s.charAt(i)=='['){
	                stkstr.add(res);
	                res="";
	                i++;
	            }else if(s.charAt(i)==']'){
	                StringBuilder sb = new StringBuilder(stkstr.pop());
	                int num = stknum.pop();
	                while(num>0){
	                    sb.append(res);
	                    num--;
	                }
	                res=sb.toString();
	                i++;
	                
	            }else{
	                res+=s.charAt(i++);
	                
	            }
	        }
	        
	        return res;
	    }
	
}
