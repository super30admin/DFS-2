import java.util.Stack;

public class DecodeString {
      /*
    Depth First Approach: Decode the baby combine it with it's parent
    1. inner most string (most nested string) should be decoded first and it has to be combined with its parent
    2. we are going to the depth, ex: 2[a2[c3[de]]]
    this a2[c3[de]] cannot be decoded until this is not decoded c3[de]
    and c3[de] cannot be decoded until de is decoded
    3. once we have decoded de then it has be be concatenated with it's parent
    2[a2[c3[de]]z2[x]] output of a2[c3[de]]z acts as a parent to further string 2[x]
    4. The last present element in the stack is the parent
    5. Since number can be 2 digit so we can do last number *10 +2 to form the 2 digit number
    6. Maintains an integer stack to put number to repeat the current string that is decoded. 
    7. Once we encounter an open bracket, we also put the parent in stack. 

    Space: O(k), where k is the length of the input string
    Time: Length of the output
    
    */
    public String decodeString(String s) {
        Stack<StringBuilder> strSt=new Stack<>();
        Stack<Integer> st=new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        for(int i=0; i< s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum = currNum*10 + (c-'0'); 
            }
            else if(c == '[')
            {
                //new baby has started
                st.push(currNum);
                //parent needs to go inside the stack
                strSt.push(currStr);
                currStr= new StringBuilder();
                currNum=0;
            }
             else if(c == ']')
            {
                 //decoding current string
                 int num = st.pop();
                 StringBuilder parent = strSt.pop();
                 for(int j=0;j<num;j++)
                 {
                     parent.append(currStr);
                     
                 }
                 currStr = parent;
                
            }
            else{
                //alphabet
                currStr.append(c);
            }
        }
        
        return currStr.toString();
        
    }
}
