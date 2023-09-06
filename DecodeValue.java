import java.util.Stack;

public class DecodeValue {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeValue obj = new DecodeValue();
        String obj1 = obj.decodeString(s);
        System.out.println(obj1);

    }

    public String decodeString(String s) {

        Stack<Integer> numSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        Integer currNum = 0;

        for (int i = 0 ; i <s.length() ; i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){

                 currNum = currNum*10 + (c -'0');

            }else if (c =='['){
                numSt.push(currNum);
                strSt.push(currStr);
                currNum = 0;
                currStr = new StringBuilder();

            }else if(c == ']'){
                int val = numSt.pop();
                StringBuilder child = new StringBuilder();
                for (int k = 0; k < val ; k++){
                 // StringBuilder child = new StringBuilder();
                  child.append(currStr);  
                }
                // StringBuilder parent = strSt.pop();
                // currStr =  parent.append(child);
                 currStr = strSt.pop().append(child);

            }else{
                currStr.append(c);
            }

        }
        return currStr.toString();
        
    }
}