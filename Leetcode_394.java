//way1
//Stack 
//At every place - check the character and perform respectice action
//TC: Product of all numbers in string * length of String
//SC: Product of all numbers in string * length of String
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> st=new Stack();
        Stack<Integer> stCount=new Stack();

        StringBuilder sb=new StringBuilder();
        int count=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'){
                sb.append(ch);
            }else if(ch=='['){
                st.add(sb);
                stCount.add(count);
                sb=new StringBuilder();
                count=0;

            }else if(ch==']'){
                int prevCount=stCount.pop();
                StringBuilder prev=new StringBuilder();
                for(int j=0;j<prevCount;j++){
                    prev.append(sb);
                }
                StringBuilder p=st.pop();
                p.append(prev);
                sb=new StringBuilder();
                sb.append(p);

            }else{
                count=(count*10)+(ch-'0');
            }

        }

        return sb.toString();
        
    }
}


//way2
//Stack 
//At every place - check the character and perform respectice action
//TC: Product of all numbers in string * length of String
//SC: Product of all numbers in string * length of String
class Solution {
    int i=0;
    public String decodeString(String s) {

        StringBuilder sb=new StringBuilder();
        int count=0;

       while(i<s.length()){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'){
                sb.append(ch);
                i++;
            }else if(ch=='['){
                i++;
                String baby=decodeString(s);
                
                for(int j=0;j<count;j++){
                    sb.append(baby);
                }
                count=0;
                
            }else if(ch==']'){
                i++;
                return sb.toString();
            }else{
                count=(count*10)+(ch-'0');
                i++;
            }

        }

        return sb.toString();
        
    }
}
