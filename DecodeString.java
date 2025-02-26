import java.util.Stack;

public class DecodeString {
    int i;
    public String decodeString(String s) {
        Stack<Integer> numst = new Stack<>();
        Stack <StringBuilder> strst = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + c - '0';
                i++;
            } else if (c == '['){
                i++;
                String decoded=decodeString(s);
                StringBuilder child=new StringBuilder();
                for(int i=0;i<currNum;i++){
                    child.append(decoded);
                }
                currStr.append(child);
                currNum=0;
                i++;
            }else if ( c == ']'){
                return currStr.toString();
            } else {

                currStr.append(c);
                i++;

            }

        }
        return currStr.toString();
    }
}

//non resursive

/*
    public String decodeString(String s) {
      Stack <Integer> numst = new Stack<>();
      Stack <StringBuilder> strst = new Stack<>();
      StringBuilder currStr = new StringBuilder();
      int currNum = 0;
      for(int i = 0; i < s.length(); i++){
          char c = s.charAt(i);
          if(Character.isDigit(c)){
              currNum = currNum * 10 + c - '0';
          } else if (c == '['){
              // At the starting of square bracket push the past strings in string stack and num for future string in num stack
              numst.push(currNum);
              strst.push(currStr);
              currNum = 0;
              currStr = new StringBuilder();
          }else if ( c == ']'){
              // At end of square bracket process the past string
              int times = numst.pop();
              StringBuilder child = new StringBuilder();
              for(int j = 0;j < times; j++){
                   child.append(currStr);
              }
              StringBuilder parent = strst.pop();
              currStr=parent.append(child);
          } else {
              currStr.append(c);
          }
      }
      return currStr.toString();
    }
 */