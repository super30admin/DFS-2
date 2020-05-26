//Leetcode : 394. Decode String
//Time Complexity: O(n) 
//Space Complexity: O(n) 
class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0){
            return s;
        }        
        Stack<Integer> st1 = new Stack<>(); 
        Stack<String> st2 = new Stack<>(); 
        int t=0;
        int n=0;
        String r="";
        StringBuilder m= new StringBuilder();
        for(int i=0;i<s.length();i++){          
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                n=n*10+ (c-'0');
            }
            else{
                if(c=='[') {
                   st1.push(n);
                   st2.push(m.toString());
                    m=new StringBuilder();
                    n=0;
                }
                else{
                    if(c==']'){
                        t=st1.pop();
                         r="";
                        while(t>0){
                            r=r+m.toString();
                            t--;
                        }
                        m=new StringBuilder(st2.pop()+r);
                        
                    }
                    else{
                        m.append(c);
                    }
                }
            }
        }
            return m.toString();
    }
}